package algorithm7.leetcode.贪心;

/**
 * @Author: permission
 * @Date: 2023/2/4 3:46
 * @Version: 1.0
 * @ClassName: NC45
 * @Description: 45. 跳跃游戏 II
 */
public class LC45 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int[] nums2 = {3, 4, 3, 2, 5, 4, 3};
        int res = jump(nums);
        int res2 = jump(nums2);
        System.out.println(res);
        System.out.println(res2);

    }

    public static int jump(int[] nums) {
        return handle_greed2(nums);
    }

    private static int handle_greed2(int[] nums) {
        int n = nums.length;
        int res = 0;
        int canMaxIndex = 0;//当前能到的最大位置
        int end = 0;//上次选择后能到的最大位置
        for (int i = 0; i < n - 1; i++) {
            canMaxIndex = Math.max(canMaxIndex, i + nums[i]);
            if (i == end) {
                end = canMaxIndex;
                res++;
            }

        }
        return res;
    }

    /*
            贪心
     */
    private static int handle_greed1(int[] nums) {
        int res = 0;
        int length = nums.length;
        int end = 0;//上次跳跃可达范围右边界（下次的最右起跳点）
        int maxPosition = 0;//目前能跳到的最远位置
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {// 到达上次跳跃能到达的右边界
                end = maxPosition;// 目前能跳到的最远位置变成了下次起跳位置的有边界
                res++;// 进入下一次跳跃
            }
        }
        return res;
    }


    private static class Info {
        int index;

        public Info(int index, int value) {
            this.index = index;
            this.value = value;
        }

        int value;
    }
}
