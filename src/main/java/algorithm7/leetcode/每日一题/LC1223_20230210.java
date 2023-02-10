package algorithm7.leetcode.每日一题;

/**
 * @Author: permission
 * @Date: 2023/2/10 10:20
 * @Version: 1.0
 * @ClassName: LC1223
 * @Description: 1223. 掷骰子模拟 hard
 */
public class LC1223_20230210 {
    private static final long MOD = (long) 1e9+7;
    private static int[] rollMax;
    private static int[][][] cache;


    public static int dieSimulator(int n, int[] rollMax) {
        LC1223_20230210.rollMax = rollMax;
        int m = rollMax.length;
        cache = new int[n][m][15];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; ++j)
                for (int k = 0; k < 15; k++) {
                    cache[i][j][k] = -1;}
        long ans = 0;
        for (int j = 0; j < m; ++j)
            ans += dfs(n - 1, j, rollMax[j] - 1);
        return (int) (ans % MOD);
    }

    private static int dfs(int i, int last, int left) {
        if (i == 0) return 1;
        if (cache[i][last][left] >= 0) return cache[i][last][left];
        long res = 0;
        for (int j = 0; j < rollMax.length; ++j)
            if (j != last) res += dfs(i - 1, j, rollMax[j] - 1);
            else if (left > 0) res += dfs(i - 1, j, left - 1);
        return cache[i][last][left] = (int) (res % MOD);
    }



    public static void main(String[] args) {
/*
20
8,5,10,8,7,2
期望：822005673
 */
        int n = 20;
        int[] rollMax1 = new int[]{8,5,10,8,7,2};
        int res = dieSimulator(n, rollMax1);
        System.out.println(res);
    }
}