package algorithm7.niucode.nc.数组;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: permission
 * @Date: 2023/1/21 14:25
 * @Version: 1.0
 * @ClassName: NC62
 * @Description: NC61 两数之和
 */
public class NC61 {

    public int[] twoSum (int[] numbers, int target) {
        // write code here
        return find2(numbers, target);
    }

    private int[] find2(int[] numbers, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        int temp = 0;
        for (int i = 0; i < numbers.length; i++) {
            temp = target - numbers[i];
            if (map.containsKey(temp)) {
                res[0] = map.get(temp) + 1;
                res[1] = i + 1;
                return res;
            } else {
                map.put(numbers[i], i);
            }
        }
        return res;
    }


    // 超时
    private int[] find(int[] numbers, int target) {
        int[] res = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 1; j < numbers.length; j++) {
                if (i == j) {
                    continue;
                }
                if (numbers[i] + numbers[j] == target) {
                    if (i < j) {
                        res[0] = i + 1;
                        res[1] = j + 1;
                    } else {
                        res[0] = j + 1;
                        res[1] = i + 1;
                    }
                }
            }
        }

        return res;
    }


}
