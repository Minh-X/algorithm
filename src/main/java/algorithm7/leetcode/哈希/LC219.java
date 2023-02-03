package algorithm7.leetcode.哈希;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: permission
 * @Date: 2023/2/4 2:11
 * @Version: 1.0
 * @ClassName: LC219
 * @Description: 219. 存在重复元素 II
 */
public class LC219 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        int k = 3;
        boolean res = containsNearbyDuplicate(nums, k);
        System.out.println(res);
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
//        return handle1(nums, k);
        return handle2_hash(nums, k);
    }

    /*
            通过hash表将时间复杂度降到 O(n)
     */
    private static boolean handle2_hash(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {

            if (map.containsKey(nums[i]) && (i - map.get(nums[i])) <= k) {
                return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }

    /*
            超时
     */
    private static boolean handle1(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i != j && nums[i] == nums[j] && Math.abs(i - j) <= k) {
                    return true;
                }
            }
        }
        return false;
    }

}
