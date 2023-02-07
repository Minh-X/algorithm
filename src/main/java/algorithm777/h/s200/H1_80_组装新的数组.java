package algorithm777.h.s200;

import java.util.*;

/**
 * @Author: permission
 * @Date: 2023/2/6 3:04
 * @Version: 1.0
 * @ClassName: H1_组装新的数组
 * @Description: 200
 *                  LC39
 */
public class H1_80_组装新的数组 {

    public static void main(String[] args) {
        // 处理输入
        Scanner in = new Scanner(System.in);
        Integer[] nums = Arrays.stream(in.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        int m = in.nextInt();//target
        t.t1(nums, m);
        handle(nums, m);
    }

    private static void handle(Integer[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> cur = new LinkedList<>();
        //排序找到最小值
        Arrays.sort(nums);
        int min = nums[0];
        int ans = dfs(nums, min, 0, target, 0, 0);
        System.out.println(ans);
    }

    private static int dfs(Integer[] nums, int min, int index, int target, int sum, int count) {
        if (target == 0 || target < min) {
            return target >= 0 ? 1 : 0;//最后补的数不为负数，所以target要大于等于0
        }
        int res = 0;
        for (int i = index; i < nums.length; i++) {//剪纸，i从index
            res += dfs(nums, min, i, target - nums[i], sum, count);
        }
        return res;
    }


    static class t {
        public static int min_num;

        public static void t1(Integer[] nums, int m) {
            // 处理输入
//            Scanner in = new Scanner(System.in);
//            Integer[] nums = Arrays.stream(in.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
//            t.m = in.nextInt();

            //排序找到最小值
            Arrays.sort(nums);
            min_num = nums[0];

            System.out.println(dfs(nums, 0, 0, 0, m));
        }

        public static int dfs(Integer[] nums, int index, int sum, int count, int m) {
            if (sum > m) {
                return count;
            }

            //满足边界条件+1
            if (sum <= m && m - min_num < sum) {
                return count + 1;
            }

            for (int i = index; i < nums.length; i++) {
                count = dfs(nums, i, sum + nums[i], count, m);
            }

            return count;
        }

    }

}
