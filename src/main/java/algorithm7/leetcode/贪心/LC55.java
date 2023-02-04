package algorithm7.leetcode.贪心;

/**
 * @Author: permission
 * @Date: 2023/2/4 16:53
 * @Version: 1.0
 * @ClassName: LC55
 * @Description: 55. 跳跃游戏
 */
public class LC55 {

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
//        int[] nums = {3, 2, 1, 0, 4};
//        int[] nums = {0, 2, 3};
        boolean res = canJump(nums);
        System.out.println(res);
    }


    public static boolean canJump(int[] nums) {
//        return handle1(nums);
        return handle_LC(nums);
    }

    private static boolean handle1(int[] nums) {
        int n = nums.length;
        int canMaxIndex = 0;
        for (int i = 0; i < n - 1; i++) {
            if (i <= canMaxIndex) {
                canMaxIndex = Math.max(canMaxIndex, i + nums[i]);
            }
        }
        if (canMaxIndex < nums.length - 1) {
            return false;
        }
        return true;
    }


    private static boolean handle_LC(int[] nums) {
        int n = nums.length;
        int rightmost = 0;
        for (int i = 0; i < n; ++i) {
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }

}
