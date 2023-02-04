package algorithm7.leetcode.数组;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: permission
 * @Date: 2023/2/4 19:33
 * @Version: 1.0
 * @ClassName: LC209
 * @Description: 209. 长度最小的子数组
 */
public class LC209 {

    public static void main(String[] args) {
        int target = 5;
        int[] nums = {2, 3, 1, 1, 1, 1};
        int res = minSubArrayLen(target, nums);
        System.out.println(res);
    }

    public static int minSubArrayLen(int target, int[] nums) {
//        return handle_violence(target, nums);
//        return handle_slideWindow(target, nums);
        return handle_slideWindow2(target, nums);
    }

    /*
            滑动窗口（双指针）
     */
    private static int handle_slideWindow2(int target, int[] nums) {
        int n = nums.length;
        int L = 0;
        int R = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;
        while (R < n) {
            sum += nums[R];
            while (sum >= target) {
                minLength = Math.min(minLength, R - L + 1);
                sum -= nums[L];
                L++;
            }
            R++;
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    /*
            滑动窗口（双端队列）
     */
    private static int handle_slideWindow(int target, int[] nums) {
        int n = nums.length;
        int minLength = Integer.MAX_VALUE;
        int sum_window = 0;
        Deque<Integer> window = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            sum_window += nums[i];
            window.offerLast(nums[i]);
//            if (sum_window >= target) {
//                minLength = Math.min(minLength, window.size());
//            }
            while (sum_window >= target) {
                minLength = Math.min(minLength, window.size());
                sum_window -= window.pollFirst();
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    /*
            暴力（超时）
     */
    private static int handle_violence(int target, int[] nums) {
        int n = nums.length;
        int minLength = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int sum = nums[i];
            if (sum >= target) {//只取[i]就满足
                return 1;
            }
            for (int j = i + 1; j < n; j++) {//从i+1取，取到大于等于target，记录下长度
                sum += nums[j];
                int length = j - i + 1;
                if (sum >= target) {//取完
                    minLength = Math.min(minLength, length);
                    break;
                }
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

}
