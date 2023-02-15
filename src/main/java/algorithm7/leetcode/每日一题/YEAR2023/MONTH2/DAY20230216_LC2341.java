package algorithm7.leetcode.每日一题.YEAR2023.MONTH2;

import java.util.HashMap;

/**
 * @Author: permission
 * @Date: 2023/2/16 6:01
 * @Version: 1.0
 * @ClassName: DAY20230216_LC2341
 * @Description: 2341. 数组能形成多少数对
 */
public class DAY20230216_LC2341 {

    public static void main(String[] args) {

//        int[] nums = {1, 3, 2, 1, 3, 2, 2};
        int[] nums = {0};
        int[] ans = numberOfPairs(nums);
        for (int r : ans) {
            System.out.print(r + " ");
        }
    }

    public static int[] numberOfPairs(int[] nums) {
        return handle(nums);
    }

    private static int[] handle(int[] nums) {
        int[] res = new int[2];
        int n = nums.length;
        int times = 0;
        int rest = n;
        HashMap<Integer, Integer> map = new HashMap<>();//nums[index]-index
        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums[i])) {
                Integer lastIndex = map.get(nums[i]);

                map.remove(nums[i]);
                nums[lastIndex] = Integer.MIN_VALUE;
                nums[i] = Integer.MIN_VALUE;
                times++;
            } else {
                map.put(nums[i], i);
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] == Integer.MIN_VALUE) {
                rest--;
            }
        }
        res[0] = times;
        res[1] = rest;
        return res;
    }

}
