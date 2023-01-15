package algorithm7.leetcode.字符串;

/**
 * @Author: permission
 * @Date: 2023/1/15 19:12
 * @Version: 1.0
 * @ClassName: LC125
 * @Description: 796. 旋转字符串
 */
public class LC796 {

    public static void main(String[] args) {
        rotateString("", "");
    }

    public static boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        return -1 == kmp(s + s, goal) ? false : true;
    }

    private static int kmp(String base, String target) {
        if (base.length() < target.length()) {
            return -1;
        }
        char[] s1 = base.toCharArray();
        char[] s2 = target.toCharArray();
        int[] next = getNextArray(s2);
        int x = 0;
        int y = 0;
        while (x < s1.length && y < s2.length) {
            if (s1[x] == s2[y]) {
                x++;
                y++;
            } else if (next[y] >= 0) {
                y = next[y];
            } else {
                x++;
            }
        }
        return y == s2.length ? x - y : -1;
    }

    private static int[] getNextArray(char[] s) {
        if (s.length == 1) {
            return new int[] {-1};
        }
        int[] next = new int[s.length];
        next[0] = -1;
        next[1] = 0;
        int i = 2;
        int pnv = 0;
        while (i < s.length) {
            if (s[i] == s[pnv]) {
                pnv++;
                next[i] = pnv;
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
