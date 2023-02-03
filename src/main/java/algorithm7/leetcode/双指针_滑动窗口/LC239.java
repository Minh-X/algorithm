package algorithm7.leetcode.双指针_滑动窗口;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: permission
 * @Date: 2023/2/3 22:40
 * @Version: 1.0
 * @ClassName: LC239
 * @Description: 239. 滑动窗口最大值
 */
public class LC239 {

    public static void main(String[] args) {
        int k = 3;
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] res = maxSlidingWindow(nums, k);
        for (int i : res) {
            System.out.print(i + " ");
        }
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
//        return handle_doublePoint(nums, k);
        return handle_slidingWindow(nums, k);
    }

    /*
            双端队列
     */
    private static int[] handle_slidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        int index = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        int R = 0;
        int L = R - k + 1;
        while (R < nums.length) {
            while (!deque.isEmpty() && nums[R] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(R);//放下标
            while (deque.peekFirst() < L) {//过期
                deque.pollFirst();
            }
            if (R >= k - 1) {
                res[index++] = nums[deque.peekFirst()];
            }
            R++;
            L++;
        }
        return res;
    }

    /*
            双指针
     */
    private static int[] handle_doublePoint(int[] nums, int k) {
        int R = k - 1;
        int L = 0;
        int[] res = new int[nums.length - k + 1];
        int index = 0;
        for (; R < nums.length; R++) {
            int max = nums[R];
            for (int i = 1; i < k; i++) {
                max = Math.max(max, nums[R - i]);
            }
            res[index] = max;
            index++;
        }
        return res;
    }
}
