package algorithm777.h7.s200;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: permission
 * @Date: 2023/2/13 19:55
 * @Version: 1.0
 * @ClassName: H8_最大平分数组
 * @Description: 200
 */
public class H8_最大平分数组 {

    public static void main(String[] args) {

/*
7
4 3 2 3 5 2 1
期望输出：4  (5    1 4    2 3    2 3)

9
5 2 1 5 2 1 5 2 1
期望：4
 */
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        int res = handle(nums, n);
        System.out.println(res);
    }

    private static int handle(int[] nums, int n) {
        //降序排序，前面的桶可以先放满，剪枝可以剪更多
        //这里用stream会慢很多
        nums = Arrays.stream(nums).boxed().sorted((a, b) -> b - a).mapToInt(value -> value).toArray();
        int sum = Arrays.stream(nums).sum();

        for (int k = n; k >= 1; k--) {//能不能分为k个桶，直接从最大开始往低，最大的如果可以直接返回

                if (sum % k != 0) {
                    continue;
                }
                int target = sum / k;
                if (dfs(0, nums, n, new int[k], target)) {
                    return k;
                }
            }
        return 0;
    }

    private static boolean dfs(int index, int[] nums, int n, int[] bucket, int target) {
        if (index == n) {
//            for (int buk : bucket) {//优化，可以不用判断
//                if (buk != target) {
//                    return false;
//                }
//            }
            return true;
        }
        // 尝试将index放到第i个桶
        for (int i = 0; i < bucket.length; i++) {
            if (i > 0 && index == 0) break;//优化，index等于0（第一个）直接放在第一个桶，尝试放其他桶时直接break
            if (bucket[i] + nums[index] > target) {
                continue;//剪枝，第i个桶放不下，放下一个桶
            } else {
                bucket[i] += nums[index];
                //去index + 1考虑
                boolean curRes = dfs(index + 1, nums, n, bucket, target);
                if (curRes) {
                    return true;
                }
                bucket[i] -= nums[index];
            }
        }
        return false;
    }

}
