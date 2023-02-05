package algorithm7.leetcode.字符串;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author: permission
 * @Date: 2023/1/15 14:26
 * @Version: 1.0
 * @ClassName: LC151
 * @Description: 151. 反转字符串中的单词
 */
public class LC151 {
    public static void main(String[] args) {
        String s = "a good   example";
        String res = reverseWords(s);
        System.out.println(res);
    }

    public static String reverseWords(String s) {
        return t1(s);
    }

    public static String t1(String s) {
        s = s.trim();
        String[] splits = s.split("\\ +");
        StringBuilder sb = new StringBuilder();
        for (int i = splits.length - 1; i > 0.; i--) {
            sb.append(splits[i]).append(" ");
        }
        sb.append(splits[0]);
        return sb.toString();
    }

    public static String t2(String s) {
        s = s.trim();
        String[] splits = s.split("\\s+");
        List<String> list = Arrays.asList(splits);
        Collections.reverse(list);
        String res = String.join(" ", list);
        return res;
    }

}
