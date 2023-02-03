package algorithm7.leetcode.哈希;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Author: permission
 * @Date: 2023/2/4 2:26
 * @Version: 1.0
 * @ClassName: LC136
 * @Description: 136. 只出现一次的数字
 */
public class LC136 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        int res = singleNumber(nums);
        System.out.println(res);
    }

    public static int singleNumber(int[] nums) {
//        return handle_hash(nums);
        return handle2(nums);
    }

    private static int handle_hash(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        Set<Integer> keySet = map.keySet();
        int res = 0;
        for (Integer key : keySet) {
            if (map.get(key) == 1) {
                res = key;
            }
        }
        return res;
    }


    /*
        位运算
                1 任何数和0做异或，结果为其本身
                2 任何数和自己本身做异或运算，结果为0
                3 异或运算满足交换律和结合律

             题中，只有一个数出现一次，其余都出现两次
             利用上面两条特性，数组中所有数互相做异或，即可消除出现两次的数，剩下出现一次的数

    */
    private static int handle2(int[] nums) {
        int res = nums[0];//根据第三条性质，即使出现一次的在第0号位，先和其他的出现两次的异或了没事（满足交换律和结合律，无关先后顺序，只和次数相关）
        for (int i = 1; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }
}
