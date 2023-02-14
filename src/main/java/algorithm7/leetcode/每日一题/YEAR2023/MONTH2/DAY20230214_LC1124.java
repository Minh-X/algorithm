package algorithm7.leetcode.每日一题.YEAR2023.MONTH2;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: permission
 * @Date: 2023/2/14 14:58
 * @Version: 1.0
 * @ClassName: DAY20230214_LC1124
 * @Description: 1124. 表现良好的最长时间段
 */
public class DAY20230214_LC1124 {

    public static void main(String[] args) {
//        int[] hours = {9, 9, 6, 0, 6, 6, 9};
//        int[] hours = {9, 6, 6, 0, 6, 9, 9};
        int[] hours = {8, 10, 6, 16, 5};//期望：3
        int res = longestWPI(hours);
        System.out.println(res);
    }

    public static int longestWPI(int[] hours) {
        return handle(hours);
//        return handle2(hours);
    }

    private static int handle2(int[] hours) {
        int n = hours.length;
        int[] s = new int[n + 1];//前缀和
        Deque<Integer> deque = new ArrayDeque<>();//单调栈
        deque.push(0);
        for (int i = 1; i < n; i++) {
            s[i] = s[i - 1] + (hours[i - 1] > 8 ? 1 : -1);
            if (s[deque.peek()] > s[i]) {
                deque.push(i);
            }
        }

        int res = 0;
        return res;
    }

    private static int handle(int[] hours) {
        int n = hours.length;
        int[] s = new int[n + 1];
        Deque<Integer> stk = new ArrayDeque<Integer>();
        stk.push(0);
        for (int i = 1; i <= n; i++) {
            s[i] = s[i - 1] + (hours[i - 1] > 8 ? 1 : -1);
            if (s[stk.peek()] > s[i]) {
                stk.push(i);
            }
        }
        int res = 0;
        for (int r = n; r >= 1; r--) {
            while (!stk.isEmpty() && s[stk.peek()] < s[r]) {
                res = Math.max(res, r - stk.pop());
            }
        }
        return res;
    }
}
