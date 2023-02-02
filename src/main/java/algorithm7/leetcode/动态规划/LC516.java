package algorithm7.leetcode.动态规划;

/**
 * @Author: permission
 * @Date: 2023/2/1 19:27
 * @Version: 1.0
 * @ClassName: LC
 * @Description: 516. 最长回文子序列
 */
public class LC516 {

    /*
        思路1：将s逆序得到s1， 求s、s1的最长公共子序列即为s的最长回文子序列

        思路2：int solution(s, left, right) 递归函数f，求s串中left到right的最长回文子序列，返回最大长度
 */
    public static int longestPalindromeSubseq(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] charArray = s.toCharArray();
        return handle2_dp(charArray, 0, charArray.length - 1);
    }

    /*
            dp
     */
    private static int handle2_dp(char[] s, int left, int right) {
        int N = s.length;
        int[][] dp = new int[N][N];
        for (int i = 0; i < N; i++) {//第一个边界条件（对角线全1）
            dp[i][i] = 1;
        }
        for (int i = 0; i < N - 1; i++) {//第二个边界条件
            dp[i][i+1] = s[i] == s[i+1] ? 2 : 1;
        }
        for (int i = N-3; i >= 0 ; i--) {
            for (int j = i + 2; j < N; j++) {
                // int p1 = dp[i+1][j-1];/* 优化，可以不要。因为左不可能比左下小（左在上一次取最大时当前左下是上一次的下，在上一次已经被过滤掉） */
                int p2 = dp[i][j-1];
                int p3 = dp[i+1][j];
                int p4 = 0;
                if (s[i] == s[j]) {
                    p4 = 2 + dp[i+1][j-1];
                }
//                dp[i][j] = Math.max(Math.max(p1, p2), Math.max(p3, p4));
                dp[i][j] = Math.max(p2, Math.max(p3, p4));
            }

        }
        return dp[left][right];
    }


}
