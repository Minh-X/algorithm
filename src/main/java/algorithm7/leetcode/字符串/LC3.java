package algorithm7.leetcode.字符串;

import java.util.HashSet;

/**
 * @Author: permission
 * @Date: 2023/2/4 20:48
 * @Version: 1.0
 * @ClassName: LC3
 * @Description: 3. 无重复字符的最长子串
 */
public class LC3 {

    public static void main(String[] args) {
        String s = "pwwkew";
        int res = lengthOfLongestSubstring(s);
        System.out.println(res);
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s==null || s.length()==0) {
            return 0;
        }
        return handle_slideWindow1(s);
    }
    /*
            滑动窗口（双指针）
     */
    private static int handle_slideWindow1(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int maxLen = 0;
        int r = 0;
        int l = 0;
        HashSet<Character> set = new HashSet<>();
        while (r < n) {
            if (set.contains(chars[r])) {
                while (chars[l] != chars[r]) {
                    set.remove(chars[l]);
                    l++;
                }
                r++;
                l++;
            } else {
                set.add(chars[r]);
                maxLen = Math.max(maxLen, r - l + 1);
                r++;
            }
        }

        return maxLen;
    }

}
