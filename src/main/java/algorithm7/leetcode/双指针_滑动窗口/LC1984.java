package algorithm7.leetcode.双指针_滑动窗口;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @Author: permission
 * @Date: 2023/2/4 0:22
 * @Version: 1.0
 * @ClassName: LC1984
 * @Description: 1984. 学生分数的最小差值
 */
public class LC1984 {

    public static void main(String[] args) {
        int[] nums = {4, 7, 1, 9};
        int k = 3;
        int res = minimumDifference(nums, k);
        System.out.println(res);

    }

    public static int minimumDifference(int[] nums, int k) {
        return handle1(nums, k);
    }

    /*
            先排序，因为有序，最高分和对低分差值最小的是选出的k个数的最右和最左
            如   1 4 7 9  当k=3，一定是 7-1 和 9-4 中取最小的值为答案
     */
    private static int handle1(int[] nums, int k) {
        Arrays.sort(nums);
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - k + 1; i++) {
            res = Math.min(res, nums[i + k - 1] - nums[i]);
        }
        return res;
    }
}
