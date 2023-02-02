package algorithm7.niucode.nc.字符串;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: permission
 * @Date: 2023/1/22 3:13
 * @Version: 1.0
 * @ClassName: NC17
 * @Description: NC17 最长回文子串
 */
public class NC17 {

    public static void main(String[] args) {
        getLongestPalindrome("ababc");
    }

    public static int getLongestPalindrome (String A) {
        // write code here
        return find(A);
    }

    private static int find(String a) {
        if (a == null || a.length() == 0) {
            return 0;
        }
        if (a.length() == 1) {
            return 1;
        }
        char[] chars = a.toCharArray();
        int maxLen = 1;
        int curLen = 1;
        for (int i = 1; i < chars.length; i++) {

        }
        return 0;
    }


}
