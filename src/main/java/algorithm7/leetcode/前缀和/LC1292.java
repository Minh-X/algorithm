package algorithm7.leetcode.前缀和;

/**
 * @Author: permission
 * @Date: 2023/2/6 21:27
 * @Version: 1.0
 * @ClassName: LC1292
 * @Description: 1292. 元素和小于等于阈值的正方形的最大边长
 */
public class LC1292 {

    public static void main(String[] args) {
        int[][] mat = {{1, 1, 3, 2, 4, 3, 2}, {1, 1, 3, 2, 4, 3, 2}, {1, 1, 3, 2, 4, 3, 2}};
        int threshold = 4;
        int res = maxSideLength(mat, threshold);
        System.out.println(res);
    }

    public static int maxSideLength(int[][] mat, int threshold) {
        return handle1(mat,threshold);
    }

    /*
            前缀和
     */
    private static int handle1(int[][] mat, int threshold) {
        int row = mat.length;
        int col = mat[0].length;
        //生成二维前缀数组
        int[][] prefix = new int[row + 1][col + 1];
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                prefix[i][j] = mat[i - 1][j - 1] + prefix[i][j - 1] + prefix[i - 1][j] - prefix[i - 1][j - 1];
            }
        }
        int ans = 0;

        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                for (int k = 1; k <= i && k<=j; k++) {
                    int temp = prefix[i][j] - prefix[i - k][j] - prefix[i][j - k] + prefix[i - k][j - k];
                    if (temp <= threshold) {
                        ans = Math.max(ans, k);
                    } else{
                        break;//边长小都不满足，下次循环k+1肯定不会满足，直接break（从80ms提速到20ms）
                    }
                }
            }
        }
        return ans;
    }
}
