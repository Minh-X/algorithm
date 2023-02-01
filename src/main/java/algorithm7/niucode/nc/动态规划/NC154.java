package algorithm7.niucode.nc.动态规划;

/**
 * @Author: permission
 * @Date: 2023/2/1 17:56
 * @Version: 1.0
 * @ClassName: NC154
 * @Description: NC154 最长回文子序列
 */
public class NC154 {

    public static void main(String[] args) {
        String s = "abccsb";
        int res = handle2_recursion(s.toCharArray(), 0, s.length() - 1);
        int res2 = handle2_dp(s.toCharArray(), 0, s.length() - 1);
        System.out.println(res);
        System.out.println(res2);
    }

    /*
            题解1：将s逆序得到s1， 求s、s1的最长公共子序列即为s的最长回文子序列

            题解2：int solution(s, left, right) 递归函数f，求s串中left到right的最长回文子序列，返回最大长度
     */
    public static int longestPalindromeSubSeq(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] charArray = s.toCharArray();
//        return handle2_recursion(charArray, 0, charArray.length - 1);
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
                int p1 = dp[i+1][j-1];
                int p2 = dp[i][j-1];
                int p3 = dp[i+1][j];
                int p4 = 0;
                if (s[i] == s[j]) {
                    p4 = 2 + dp[i+1][j-1];
                }
                dp[i][j] = Math.max(Math.max(p1, p2), Math.max(p3, p4));
            }

        }
        return dp[left][right];
    }


    /*
        题解2
        暴力递归
        递归求 s[L...R]的最长回文子序列，返回最大长度
     */
    private static int handle2_recursion(char[] s, int left, int right) {
        if (left == right) {//边界条件，只有一个字符
            return 1;
        }
        if (left == right - 1) {//边界条件，只剩两个字符，如果两个字符一样，返回2，不相等返回1
            return s[left] == s[right] ? 2 : 1;
        }
        int p1 = handle2_recursion(s, left + 1, right - 1);//既不以left开头也不以right结尾，递归求s[l+1,r-1]
        int p2 = handle2_recursion(s, left, right - 1);//以left开头也不以right结尾，递归求s[l,r-1]
        int p3 = handle2_recursion(s, left + 1, right);//不以left开头以right结尾，递归求s[l+1,r]
        int p4 = 0;
        if (s[left] == s[right]) {
            p4 = 2 + handle2_recursion(s, left + 1, right - 1);//以left开头 以right结尾，递归求s[l+1,r-1]，结果+2（前后两个字符）
        }
        return Math.max(Math.max(p1, p2), Math.max(p3, p4));
    }


}
