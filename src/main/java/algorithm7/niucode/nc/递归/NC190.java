package algorithm7.niucode.nc.递归;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * @Author: permission
 * @Date: 2023/1/29 15:24
 * @Version: 1.0
 * @ClassName: NC190
 * @Description: NC190 字符串的全部子序列
 */
public class NC190 {

    public static void main(String[] args) {
        String[] strings = generatePermutation("ab");
        for (String string : strings) {
            System.out.println(string);
        }
    }

    static HashSet<String> res = new HashSet<>();

    public static String[] generatePermutation (String s) {
        // write code here
        char[] charArray = s.toCharArray();
        handle_recursion(charArray, 0, res, "");
        return res.toArray(new String[res.size()]);
    }

    private static void handle_recursion(char[] charArray, int index,HashSet<String> res, String subsequence) {
        if (index == charArray.length) {
            res.add(subsequence);
            return;
        }
        handle_recursion(charArray, index + 1, res, subsequence);
        handle_recursion(charArray, index + 1, res, subsequence + charArray[index]);
    }
}
