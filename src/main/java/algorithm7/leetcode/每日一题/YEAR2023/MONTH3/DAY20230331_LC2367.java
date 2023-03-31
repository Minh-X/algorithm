package algorithm7.leetcode.每日一题.YEAR2023.MONTH3;

import org.junit.jupiter.api.Test;

import java.util.HashSet;

/**
 * @Author: permission
 * @Date: 2023/3/31 21:20
 * @Version: 1.0
 * @ClassName: DAY20230331_LC2367
 * @Description:
 */

public class DAY20230331_LC2367 {

    public int arithmeticTriplets(int[] nums, int diff) {
//        return handle_violence(nums, diff);
        return handle_set(nums, diff);
    }

    // 哈希集合
    // 由于给定的数组 nums 是严格递增的，因此数组中不存在重复元素，不存在两个相同的算术三元组
    private int handle_set(int[] nums, int diff) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int res = 0;
        for (int num : nums) {
            if (set.contains(num + diff) && set.contains(num + 2 * diff)) {
                res++;
            }
        }
        return res;
    }

    // 暴力
    private int handle_violence(int[] nums, int diff) {
        int len = nums.length;
        int res = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (diff == nums[j] - nums[i]) {
                    for (int k = j + 1; k < len; k++) {
                        if (diff == nums[k] - nums[j]) {
                            res++;
                        }
                    }
                }
            }
        }
        return res;
    }

    @Test
    void test() {
        int[] nums = {0, 1, 4, 6, 7, 10};
        int diff = 3;
        int res = arithmeticTriplets(nums, diff);
        System.out.println(res);
    }

}
