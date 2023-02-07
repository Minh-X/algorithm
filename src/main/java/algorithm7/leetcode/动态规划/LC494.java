package algorithm7.leetcode.动态规划;

/**
 * @Author: permission
 * @Date: 2023/2/2 14:46
 * @Version: 1.0
 * @ClassName: LC494
 * @Description: 494. 目标和
 */
public class LC494 {

    public static int findTargetSumWays(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return handle_recursion(nums, 0, target);
//        return handle_dp(nums, 0, target);
    }

    private static int handle_dp(int[] nums, int index, int rest) {
        //TODO

        return 0;
    }

    /*
        暴力递归
     */
    private static int handle_recursion(int[] nums, int index, int rest) {
        if (index == nums.length) {
            return rest == 0 ? 1 : 0;
        }
        return handle_recursion(nums, index + 1, rest - nums[index]) + handle_recursion(nums, index + 1, rest + nums[index]);
    }
}
