package algorithm777.h.s200;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: permission
 * @Date: 2023/2/8 22:52
 * @Version: 1.0
 * @ClassName: H7_95_求小火车最多人时所在园区站点_人数最多的站点
 * @Description: 200
 */
public class H7_95_求小火车最多人时所在园区站点_人数最多的站点 {

    public static void main(String[] args) {
/*
3
1 3
2 4
1 4
输出：2
*/
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] nums = new int[n][2];
        for (int i = 0; i < n; i++) {
            int start = in.nextInt();
            int end = in.nextInt();
            int[] pair = {Math.min(start, end), Math.max(start, end)};
            nums[i] = pair;
        }
        handle1(n, nums);
        handle2(n, nums);
    }

    private static void handle2(int n, int[][] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();//站点-人数
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                int start = nums[i][0];
                int end = nums[i][1];
                for (int k = start; k <= end; k++) {
                    map.put(k, map.getOrDefault(k, 0) + 1);
                }
            }
        }
        List<Map.Entry<Integer, Integer>> collect = map.entrySet().stream().sorted((o1, o2) -> {
            if (o1.getValue() != o2.getValue()) {
                return o2.getValue() - o1.getValue();
            } else {
                return o1.getKey() - o2.getKey();
            }
        }).collect(Collectors.toList());
        System.out.println(collect.get(0).getKey());
    }

    private static void handle1(int n, int[][] nums) {
        //创建人数的数据结构
        HashMap<Integer, Integer> site_map = new HashMap<>();
        for (int[] pair : nums) {
            for (int i = pair[0]; i <= pair[1]; i++) {
                site_map.put(i, site_map.getOrDefault(i, 0) + 1);
            }
        }
        LinkedList<Map.Entry<Integer, Integer>> sites = new LinkedList<>(site_map.entrySet());

        //按人数排序
        sites.sort((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()));

        System.out.println(sites.get(0).getKey());
    }
}

