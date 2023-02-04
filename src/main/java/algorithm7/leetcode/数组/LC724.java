package algorithm7.leetcode.数组;

import java.util.Arrays;

/**
 * @Author: permission
 * @Date: 2023/2/4 19:22
 * @Version: 1.0
 * @ClassName: LC724
 * @Description: 724. 寻找数组的中心下标
 */
public class LC724 {

    public static void main(String[] args) {
        int[] nums = {2, 1, -1};
        int res = pivotIndex(nums);
        System.out.println(res);
    }

    public static int pivotIndex(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        return handle1(nums);
    }

    /*
            前缀和
     */
    private static int handle1(int[] nums) {
        int n = nums.length;
        int sum_all = Arrays.stream(nums).sum();
        int sum_left = 0;
        for (int i = 0; i < n; i++) {
            if (sum_all == 2 * sum_left + nums[i]) {
                return i;
            }
            sum_left += nums[i];
        }
        return -1;
    }

}
