package algorithm777.h.s100;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @Author: permission
 * @Date: 2023/2/7 2:15
 * @Version: 1.0
 * @ClassName: H5_85_发现新词的数量_新词挖掘
 * @Description: 100
 */
public class H5_85_发现新词的数量_新词挖掘 {

    public static void main(String[] args) {
/*
qweebaewqd
qwe
期望：2

abab
ab
期望输出：3

abacb
ab
期望输出：3
 */
        // 处理输入
//        Scanner in = new Scanner(System.in);
//        String content = in.nextLine();
//        String word = in.nextLine();
        String content = "abab";
        String word = "ab";
        System.out.println(handle2(content, word));
        System.out.println(contin(content, word));
    }

    /*
            将 word排序， 在content中截取word长度字串并排序，如果和word排序相等，结果+1
     */
    private static int handle2(String content, String word) {
        if (content == null || word == null || word.length() == 0 || content.length() == 0 || word.length() < content.length()) {
            return 0;
        }
        char[] contents = content.toCharArray();
        char[] words = word.toCharArray();
        Arrays.sort(words);
        int l = 0;
        int r = word.length() - 1;
        int res = 0;
        while (r < content.length()) {
            String subs = content.substring(l, r + 1);
            char[] subChars = subs.toCharArray();
            Arrays.sort(subChars);
            boolean flag = true;
            for (int i = 0; i < word.length(); i++) {
                if (words[i] != subChars[i]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                res++;
            }
            l++;
            r++;
        }
        return res;
    }



    public static int contin(String content, String word) {
        if (content.length() < word.length())
            return 0;
        if (word.length() == 0)
            return 0;
        HashMap<Character, Integer> content_map = new HashMap<Character, Integer>();
        HashMap<Character, Integer> word_map = new HashMap<Character, Integer>();
        //先统计出word中的字符组成
        for (int i = 0; i < word.length(); i++)
            word_map.put(word.toCharArray()[i], word_map.getOrDefault(word.toCharArray()[i], 0) + 1);

        char[] content_arr = content.toCharArray();
        int word_char_kind = word_map.size();
        int right = 0;
        int content_child_char_kind = 0;
        int result = 0;
        while (right < content.length()) {
            if (right >= word.length()) {
                int left = right - word.length();
                if (word_map.containsKey(content_arr[left]) && word_map.get(content_arr[left]) == content_map.get(content_arr[left]))
                    content_child_char_kind -= 1;
                content_map.put(content_arr[left], content_map.getOrDefault(content_arr[left], 0) - 1);

            }

            content_map.put(content_arr[right], content_map.getOrDefault(content_arr[right], 0) + 1);
            if (word_map.containsKey(content_arr[right]) && word_map.get(content_arr[right]) == content_map.get(content_arr[right]))
                content_child_char_kind += 1;
            right += 1;
            if (content_child_char_kind == word_char_kind) {
                result += 1;
            }
        }
        return result;
    }


}
