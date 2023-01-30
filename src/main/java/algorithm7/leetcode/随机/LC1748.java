package algorithm7.leetcode.随机;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: permission
 * @Date: 2023/1/30 22:24
 * @Version: 1.0
 * @ClassName: LC1748
 * @Description: 1748. 唯一元素的和
 */
public class LC1748 {

    public static void main(String[] args) {
        int[] x = {2, 3, 2, 3, 1, 2, 5, 7, 3};
        System.out.println(sumOfUnique(x));
    }

    public static int sumOfUnique(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int sum = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1)
                sum += entry.getKey();
        }
        return sum;

//        int sum = map.entrySet().stream().filter(e -> e.getValue() == 1).mapToInt(Map.Entry::getKey).sum();
//        return sum;

//        AtomicInteger sum = new AtomicInteger();
//        map.keySet().stream().forEach(key -> {
//            if (map.get(key) == 1) {
//                sum.addAndGet(key);
//            }
//        });
//        return sum.get();
    }

}
