package algorithm7.leetcode.动态规划;

/**
 * @Author: permission
 * @Date: 2023/2/5 21:48
 * @Version: 1.0
 * @ClassName: LC121
 * @Description: 121. 买卖股票的最佳时机
 */
public class LC121 {


    public static void main(String[] args) {

        int[] prices = {1, 2};
        int res = maxProfit(prices);
        System.out.println(res);

    }


    /*
            //题解套路（所有股票交易）
            https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/solution/mai-mai-gu-piao-wen-ti-by-chen-wei-f-gc4k/
     */
    public static int maxProfit(int[] prices) {
//        return handle_recursion(prices);
//        return handle_greedy(prices);
        return handle_dp(prices);
    }

    /*
            //第i天不持有 由 第i-1天不持有然后不操作 和 第i-1天持有然后卖出 两种情况的最大值转移过来
            dp[i][1][0] = Math.max(dp[i - 1][1][0], dp[i - 1][1][1] + prices[i])
            //第i天持有 由 第i-1天持有然后不操作 和 第i-1天不持有然后买入 两种情况的最大值转移过来
            dp[i][1][1] = Math.max(dp[i - 1][1][1], dp[i - 1][0][0] - prices[i])
                        = Math.max(dp[i - 1][1][1], -prices[i]) // k=0时 没有交易次数，dp[i - 1][0][0] = 0

     */
    private static int handle_dp(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;//第0天不持有股票
        dp[0][1] = -prices[0];//第0天持有股票
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], -prices[i]);
        }
        return dp[n-1][0];
    }

    /*
            只能先买再卖，所以可以一次遍历，遍历时记录最小的，后面的减最小的，得到最大的收益
     */
    private static int handle_greedy(int[] prices) {
        int n = prices.length;
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                maxProfit = Math.max(prices[i] - minPrice, maxProfit);
            }
        }
        return maxProfit;
    }

    /*
            暴力
     */
    private static int handle_recursion(int[] prices) {
        int n = prices.length;
        int maxProfit = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                maxProfit = Math.max(maxProfit, prices[j] - prices[i]);
            }
        }
        return maxProfit;
    }

}
