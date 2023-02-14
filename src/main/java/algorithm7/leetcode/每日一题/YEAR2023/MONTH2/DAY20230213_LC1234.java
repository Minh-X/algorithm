package algorithm7.leetcode.每日一题.YEAR2023.MONTH2;

/**
 * @Author: permission
 * @Date: 2023/2/13 15:53
 * @Version: 1.0
 * @ClassName: DAY20230213
 * @Description: 1234. 替换子串得到平衡字符串
 */
public class DAY20230213_LC1234 {

    public static void main(String[] args) {
        String s = "WQWRQQQW";
        int res = balancedString(s);
        System.out.println(res);
    }

    public static int balancedString(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }
        return handle(s);
    }

    /*
            滑动窗口
     */
    private static int handle(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int[] count = new int[26];
        for (int i = 0; i < n; i++) {//count数组表示某个字符出现的次数
            int j = chars[i] - 'A';
            count[j]++;
        }
        int k = n / 4;//出现次数target
        //s只含'Q', 'W', 'E', 'R'     n是4的倍数
        if (check(count, k)) {
            return 0;
        }

        int res = n;
        int l = 0;
        int r = 0;
        while (l < n) {
            while (r < n && !check(count, k)) {
                count[chars[r] - 'A']--;
                r++;
            }
            if (!check(count, k)) {
                break;
            }
            res = Math.min(res, r - l);
            count[chars[l] - 'A']++;
            l++;
        }
        return res;
    }

    private static boolean check(int[] count, int k) {
        if (count['Q' - 'A'] > k || count['W' - 'A'] > k || count['E' - 'A'] > k || count['R' - 'A'] > k ) {
            return false;
        }
        return true;
    }

}
