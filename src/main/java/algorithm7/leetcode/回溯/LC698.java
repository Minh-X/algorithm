package algorithm7.leetcode.回溯;

import java.util.Arrays;
import java.util.function.ToIntFunction;

/**
 * @Author: permission
 * @Date: 2023/2/13 17:32
 * @Version: 1.0
 * @ClassName: LC698
 * @Description: 698. 划分为k个相等的子集
 */
public class LC698 {

    public static void main(String[] args) {
//        int[] nums = {3522,181,521,515,304,123,2512,312,922,407,146,1932,4037,2646,3871,269};//第一次剪枝后可通过
//        int k = 5;
        int[] nums = {3, 3, 10, 2, 6, 5, 10, 6, 8, 3, 2, 1, 6, 10, 7, 2};//第二次剪枝后可通过
        int k = 6;
//        int[] nums = {10,1,10,9,6,1,9,5,9,10,7,8,5,2,10,8};
//        int k = 11;

        long start = System.currentTimeMillis();

        boolean res = canPartitionKSubsets(nums, k);
        System.out.println(res);

        long end = System.currentTimeMillis();
        System.out.println("耗时： " + (end - start) + " ms");
    }

    public static boolean canPartitionKSubsets(int[] nums, int k) {
//        return handle1(nums, k);
        return handle2(nums, k);
    }

    private static boolean handle2(int[] nums, int k) {
        // 降序排列（第二处优化，降序排序，前面的桶可以尽快占满，增加第一次剪枝的命中率）
//        nums = Arrays.stream(nums).boxed().sorted((a, b) -> b - a).mapToInt(value -> value).toArray();
        //使用stream慢一点

        // 排序优化
        Arrays.sort(nums);
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
//使用stream慢一点
        int n = nums.length;
        int sum = 0;
//        sum = Arrays.stream(nums).sum();
        for (int num : nums) {
            sum += num;
        }
        if (sum % k != 0) {
            return false;
        }
        int target = sum / k;
        int[] bucket = new int[k];
        return dfs(0, nums, n, bucket, k, target);
    }

    private static boolean dfs(int index, int[] nums, int n, int[] bucket, int k, int target) {
        if (index == n) {
            // 有人提出，其实这个地方不需要判断，因为当 index == num.length 时，所有球已经按要求装入所有桶，所以肯定是一个满足要求的解
            // 即：每个桶内球的和一定为 target
            //第三处优化，因为加入桶时如果大于target就不加入桶，而前面已经判断 sum % k != 0，即所有的数加到对应桶，一定有解，所以如果都加入到桶中，一定刚好是正解（优化不大。。。）
//            for (int buk : bucket) {//如果有一个桶不是target，返回false
//                if (buk != target) {
//                    return false;
//                }
//            }
            return true;
        }

        //尝试把 nums[index] 放入每个桶
        for (int i = 0; i < k; i++) {
//            if (i > 0 && index == 0) break ;//第五处优化，第一个数放在哪个桶结果都一样，直接放第一个桶，尝试将第一个数放其他桶时，直接break
            if (i > 0 && bucket[i] == bucket[i-1]) continue;// 第四处优化，如果有两个桶，两个桶容量一样，放在这个桶和放在上一个桶都一样
            //尝试放入i号桶
            if (bucket[i] + nums[index] > target) {//第一处剪枝优化（尝试放进i号桶后发现比target大，放下个桶）
                continue;
            }
            bucket[i] += nums[index];
            //放入i号桶，去 index + 1 考虑放入哪个桶
            boolean curRes = dfs(index + 1, nums, n, bucket, k, target);
            if (curRes) {
                return true;
            }
            //如果放到i号桶为false，取出
            bucket[i] -= nums[index];
        }

        return false;
    }

    public static boolean handle1(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) sum += nums[i];
        if (sum % k != 0) return false;
        int target = sum / k;
        // 排序优化
        Arrays.sort(nums);
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
        return backtrack(nums, 0, new int[k], k, target);
    }

    // index : 第 index 个球开始做选择
// bucket : 桶
    private static boolean backtrack(int[] nums, int index, int[] bucket, int k, int target) {
        // 结束条件优化
        if (index == nums.length) return true;
        for (int i = 0; i < k; i++) {
            // 优化点二
            if (i > 0 && bucket[i] == bucket[i - 1]) continue;
            // 剪枝
            if (bucket[i] + nums[index] > target) continue;
            bucket[i] += nums[index];
            if (backtrack(nums, index + 1, bucket, k, target)) return true;
            bucket[i] -= nums[index];
        }
        return false;
    }

}
