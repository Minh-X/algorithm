package algorithm7.niucode.nc.动态规划;

/**
 * @Author: permission
 * @Date: 2023/1/30 20:18
 * @Version: 1.0
 * @ClassName: NC145
 * @Description: NC145 01背包
 */
public class NC145 {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int res = knapsack(10, 2, new int[][]{{1, 2}, {10, 4}});
        long end = System.currentTimeMillis();
        System.out.println(res);
        System.out.println(start);
        System.out.println(end);
        System.out.println("耗时：" + (end - start) + "ms");
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 计算01背包问题的结果
     *
     * @param V                int整型 背包的体积
     * @param n                int整型 物品的个数
     * @param vw（volume-worth） int整型二维数组 第一维度为n,第二维度为2的二维数组,vw[i][0],vw[i][1]分别描述i+1个物品的vi,wi
     * @return int整型
     */
    public static int knapsack(int V, int n, int[][] vw) {
        //1.暴力递归
//        return handle_recursion(vw, V, 0, n);

        //2.缓存递归
//        int[][] cache = new int[n+1][V+1];
//        for (int i = 0; i <= n; i++) {
//            for (int j = 0; j <= V; j++) {
//                cache[i][j] = -1;
//            }
//        }
//        return handle_recursion2(vw, V, 0, n, cache);

        //3.动态规划
        return handle_dp(vw, V);
    }

    /*
        dp
     */
    private static int handle_dp(int[][] vw, int bagV) {
        int n = vw.length;
        int[][] dp = new int[n + 1][bagV + 1];
        //最后一行全0
        for (int i = 0; i <= bagV; i++) {
            dp[n][i] = 0;
        }
        for (int index = n - 1; index >= 0; index--) {
            for (int restV = 0; restV <= bagV; restV++) {
                int p1 = dp[index + 1][restV];
                int p2 = 0;
                int next = restV - vw[index][0] < 0 ? -1 : dp[index + 1][restV - vw[index][0]];
                if (next != -1) {
                    p2 = vw[index][1] + next;
                }
                dp[index][restV] = Math.max(p1, p2);
            }
        }
        return dp[0][bagV];
    }

    /*
            递归带缓存
            cache[index][bagV]
            index 0-n
            bagV  负数-V
     */
    private static int handle_recursion2(int[][] vw, int bagV, int index, int n, int[][] cache) {
        if (bagV < 0) {
            return -1;
        }
        if (index == n) {
            return 0;
        }
        if (cache[index][bagV] != -1) {
            return cache[index][bagV];
        }
        int ans = 0;
        //不要当前位置
        int p1 = handle_recursion2(vw, bagV, index + 1, n, cache);
        //要当前位置
        int p2 = 0;
        int next = handle_recursion2(vw, bagV - vw[index][0], index + 1, n, cache);
        if (next != -1) {
            p2 = vw[index][1] + next;
        }
        ans = Math.max(p1, p2);
        cache[index][bagV] = ans;
        return ans;
    }


    /*
            递归
     */
    private static int handle_recursion(int[][] vw, int bagV, int index, int n) {
        if (bagV < 0) {
            return -1;
        }
        if (index == n) {
            return 0;
        }
        //不要当前位置
        int p1 = handle_recursion(vw, bagV, index + 1, n);
        //要当前位置
        int p2 = 0;
        int next = handle_recursion(vw, bagV - vw[index][0], index + 1, n);
        if (next != -1) {
            p2 = vw[index][1] + next;
        }
        return Math.max(p1, p2);
    }


}
