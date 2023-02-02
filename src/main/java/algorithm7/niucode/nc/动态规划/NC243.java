package algorithm7.niucode.nc.动态规划;

/**
 * @Author: permission
 * @Date: 2023/2/2 14:37
 * @Version: 1.0
 * @ClassName: NC243
 * @Description: NC243 目标和
 */
public class NC243 {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2};
        int res = findTargetSumWays(nums, 3);
        System.out.println(res);
    }

    public static int findTargetSumWays(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return handle_recursion(nums, 0, target);
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
