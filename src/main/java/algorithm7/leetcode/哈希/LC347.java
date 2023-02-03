package algorithm7.leetcode.哈希;

import java.util.*;

/**
 * @Author: permission
 * @Date: 2023/2/4 2:51
 * @Version: 1.0
 * @ClassName: LC347
 * @Description: 347. 前 K 个高频元素
 */
public class LC347 {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        int[] res = topKFrequent(nums, k);
        for (int r : res) {
            System.out.print(r + " ");
        }
        System.out.println();
    }

    public static int[] topKFrequent(int[] nums, int k) {
        return handle_hash(nums, k);
    }

    private static int[] handle_hash(int[] nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i], hashMap.getOrDefault(nums[i], 0) + 1);
        }
        Set<Map.Entry<Integer, Integer>> entrySet = hashMap.entrySet();
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((o1, o2) -> o2.getValue() - o1.getValue());
        queue.addAll(entrySet);
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll().getKey();
        }
        return res;
    }

}
