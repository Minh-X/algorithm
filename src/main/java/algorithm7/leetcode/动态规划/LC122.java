package algorithm7.leetcode.动态规划;

/**
 * @Author: permission
 * @Date: 2023/2/5 22:56
 * @Version: 1.0
 * @ClassName: LC122
 * @Description: 122. 买卖股票的最佳时机 II
 */
public class LC122 {

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int res = maxProfit(prices);
        System.out.println(res);
    }

    public static int maxProfit(int[] prices) {
        return handle_greedy(prices);
//        return handle_dp(prices);
    }

    /*
            贪心算法只能用于计算最大利润，计算的过程并不是实际的交易过程
     */
    private static int handle_greedy(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            maxProfit = maxProfit + Math.max(0, prices[i + 1] - prices[i]);
        }
        return maxProfit;
    }


    private static int handle_dp(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;//第0天不持有股票
        dp[0][1] = -prices[0];//第0天持有股票
        for (int i = 1; i < n; i++) {
            /*
                    //第i天不持有 由 第i-1天不持有然后不操作 和 第i-1天持有然后卖出 两种情况的最大值转移过来
                    dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i])
                    //第i天持有 由 第i-1天持有然后不操作 和 第i-1天不持有然后买入 两种情况的最大值转移过来
                    dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i])
             */
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);//第i天不持有 由 第i-1天不持有然后不操作 和 第i-1天持有然后卖出 两种情况的最大值转移过来
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);//第i天持有 由 第i-1天持有然后不操作 和 第i-1天不持有然后买入 两种情况的最大值转移过来
        }
        return dp[n - 1][0];
    }

}
