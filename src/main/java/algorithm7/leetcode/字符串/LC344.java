package algorithm7.leetcode.字符串;

/**
 * @Author: permission
 * @Date: 2023/2/5 16:21
 * @Version: 1.0
 * @ClassName: LC344
 * @Description: 344. 反转字符串
 */
public class LC344 {
    public static void main(String[] args) {
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        reverseString(s);
    }


    public static void reverseString(char[] s) {
        handle1(s);
    }

    private static void handle1(char[] s) {
        int n = s.length;
        int l = 0;
        int r = n - 1;
        while (l < r) {
            s[l] = (char) (s[l] + s[r]);
            s[r] = (char) (s[l] - s[r]);
            s[l] = (char) (s[l] - s[r]);
            l++;
            r--;
        }
    }
}
