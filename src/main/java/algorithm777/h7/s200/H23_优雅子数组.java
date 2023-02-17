package algorithm777.h7.s200;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

/**
 * @Author: permission
 * @Date: 2023/2/16 18:03
 * @Version: 1.0
 * @ClassName: H23_优雅子数组
 * @Description:
 */
public class H23_优雅子数组 {

    public static void main(String[] args) {
        Integer a = 1111;
/*
7 3
1 2 3 1 2 3 1
期望输出：1

7 2
1 2 3 1 2 3 1
期望：10
 */
        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
        int n = 100000;
        int k = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
//            nums[i] = scanner.nextInt();
            nums[i] = new Random().nextInt(10000);
        }

        long start = System.currentTimeMillis();
        int res = handle(nums, n, k);
        long end = System.currentTimeMillis();

        System.out.println(res);
        System.out.println("耗时：" + (end - start) + "ms");
    }

    private static int handle(int[] nums, int n, int k) {

        int res = 0;
        for (int l = 0; l < n; l++) {
            Map<Integer, Integer> map = new HashMap<>();
            boolean flag = false;
            for (int r = l; r < n; r++) {
                int curT = map.getOrDefault(nums[r], 0) + 1;//l...r区间，nums[r]出现的次数
                map.put(nums[r], curT);
//                if (curT >= k || flag) {
                if (curT >= k) {
//                    res++;
//                    flag = true;
                    res += n - r;//优化，找到第一个大于等于的，后面的都不用再遍历（肯定全满足）
                }
            }
        }
        return res;
    }

}
