package algorithm7.leetcode.数组;

/**
 * @Author: permission
 * @Date: 2023/2/4 17:57
 * @Version: 1.0
 * @ClassName: LC35
 * @Description: 35. 搜索插入位置
 */
public class LC35 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 5, 6};
        int target = 2;
        int resIndex = searchInsert(nums, target);
        System.out.println(resIndex);
    }

    public static int searchInsert(int[] nums, int target) {
//        return handle_violence(nums, target);
        return handle_binary(0, nums.length - 1, nums, target);
    }

    private static int handle_binary(int l, int r, int[] nums, int target) {
        int n = r;
        int res = n + 1;
        while (l <= r) {
            int mid = (r - l) / 2 + l;
            if (target <= nums[mid]) {
                res = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return res;
    }

    /*
            暴力
     */
    private static int handle_violence(int[] nums, int target) {
        int i = 0;
        while (i < nums.length) {
            if (target > nums[i]) {
                i++;
                continue;
            }
            if (target <= nums[i]) {
                return i;
            }
        }
        return nums.length;
    }

}
