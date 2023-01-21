package algorithm7.niucode.hj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @Author: permission
 * @Date: 2023/1/22 0:43
 * @Version: 1.0
 * @ClassName: HJ27
 * @Description: HJ27 查找兄弟单词
 */
public class HJ27 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            List<String> list = new ArrayList<>();
            String target = null;
            int n;
            int k;
            n = in.nextInt();
            for (int i = 0; i < n; i++) {
                list.add(in.next());
            }
            target = in.next();
            k = in.nextInt();
            find(list, target, k);
        }
    }

    /*
            题中兄弟单词和旋转字符串不同
            兄弟单词：
                单词不相同（如 abc和abc不为兄弟单词）
                单词长度相同，且通过旋转能相同（如 acb和abc）（可以看作单词内每个字符排序后相等（equals））
     */
    private static void find(List<String> list, String target, int k) {
        char[] targetChars = target.toCharArray();
        Arrays.sort(targetChars);
        String tar = String.valueOf(targetChars);
        List<String> resList = list.stream().filter(e -> {
            char[] chars = e.toCharArray();
            Arrays.sort(chars);
            if (!e.equals(target) && tar.equals(String.valueOf(chars))) {
                return true;
            }
            return false;
        }).sorted().collect(Collectors.toList());
        System.out.println(resList.size());
        if (resList.size() >= k) {
            System.out.println(resList.get(k - 1));
        }
    }
}
