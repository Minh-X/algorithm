package algorithm7.niucode.nc.动态规划;

/**
 * @Author: permission
 * @Date: 2023/2/2 21:33
 * @Version: 1.0
 * @ClassName: NC59
 * @Description: NC59 矩阵的最小路径和
 */
public class NC59 {

    public static void main(String[] args) {

        int[][] matrix = {{1, 3, 5, 9}, {8, 1, 3, 4}, {5, 0, 6, 1}, {8, 8, 4, 0}};
        int i = minPathSum(matrix);
        System.out.println(i);
    }

    public static int minPathSum(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
//        return handle_recursion(m - 1, n - 1, matrix);
        return handle_dp(matrix);
    }

    /*
            dp （可以先优化成两个一维数组，因为dp[i][j] = dp[i-1][j-1] + min(dp[i][j-1], dp[i-1][j])，每次只用上一行和这一行的前面部分（dp[0][j]和dp[i][0]可以直接得出）即可退出这一行的全部）
                 再优化成一个一维数组
     */
    private static int handle_dp(int[][] matrix) {
        int row = matrix.length;
        int col = matrix.length;
        int[][] dp = new int[row][col];
        dp[0][0] = matrix[0][0];
        for (int i = 1; i < row; i++) {
            dp[i][0] = matrix[i][0] + dp[i-1][0];
        }
        for (int j = 1; j < col; j++) {
            dp[0][j] = matrix[0][j] + dp[0][j-1];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = matrix[i][j] + Math.min(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[row-1][col-1];
    }


    /*
        暴力递归
     */
    private static int handle_recursion(int i, int j, int[][] matrix) {
        if (i == 0 && j == 0) {
            return matrix[0][0];
        } else if (i == 0 && j > 0) {
            return matrix[0][j] + handle_recursion(i, j - 1, matrix);
        } else if (j == 0 && i > 0) {
            return matrix[i][0] + handle_recursion(i - 1, j, matrix);
        }
        int p1 = matrix[i][j] + handle_recursion(i - 1, j, matrix);
        int p2 = matrix[i][j] + handle_recursion(i, j - 1, matrix);
        return Math.min(p1, p2);
    }

}
