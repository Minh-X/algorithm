package algorithm7.leetcode.动态规划;

/**
 * @Author: permission
 * @Date: 2023/2/5 23:49
 * @Version: 1.0
 * @ClassName: LC53
 * @Description: 53. 最大子数组和
 */
public class LC53 {

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int res = maxSubArray(nums);
        System.out.println(res);
    }

    public static int maxSubArray(int[] nums) {
        return handle_dp(nums);
    }

    /*
        f(i)=max{f(i−1)+nums[i],nums[i]}
     */
    private static int handle_dp(int[] nums) {
        int pre = 0;
        int max = nums[0];
        for (int num : nums) {
            pre = Math.max(pre + num, num);
            max = Math.max(pre, max);
        }
        return max;
    }
}
