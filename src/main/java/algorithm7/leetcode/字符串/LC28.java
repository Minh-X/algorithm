package algorithm7.leetcode.字符串;

/**
 * @Author: permission
 * @Date: 2023/1/15 18:31
 * @Version: 1.0
 * @ClassName: LC28
 * @Description: 28. 找出字符串中第一个匹配项的下标（KMP）
 */
public class LC28 {

    public int strStr(String haystack, String needle) {
        return KMP(haystack, needle);
    }

    private int KMP(String haystack, String needle) {
        char[] s1 = haystack.toCharArray();
        char[] s2 = needle.toCharArray();

        int[] next = getNextArray(s2);
        int x = 0;
        int y = 0;
        while (x < s1.length && y < s2.length) {
            if (s1[x] == s2[y]) {
                x++;
                y++;
            } else if (next[y] == -1) {
                x++;
            } else {
                y = next[y];
            }
        }
        return y == s2.length ? x-y : -1;
    }

    private int[] getNextArray(char[] s2) {
        if (s2.length == 1) {
            return new int[] {-1};
        }
        int[] next = new int[s2.length];
        next[0] = -1;
        next[1] = 0;
        int i = 2;
        int pnv = 0;//next[i-1]的值
        while (i < s2.length) {
            if (s2[i-1] == s2[pnv]) {
                pnv++;
                next[i] = pnv;// 等同于next[i-1] + 1
                i++;
            } else if (pnv > 0) {
                pnv = next[pnv];
            } else {
                next[i] = 0;
                i++;
            }
        }
        return next;
    }


}
