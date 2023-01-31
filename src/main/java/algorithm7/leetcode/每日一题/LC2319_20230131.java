package algorithm7.leetcode.每日一题;

/**
 * @Author: permission
 * @Date: 2023/1/31 23:15
 * @Version: 1.0
 * @ClassName: LC2319_20230131
 * @Description: 2319. 判断矩阵是否是一个 X 矩阵
 */
public class LC2319_20230131 {

    /*

    [ 6, 0, 0, 0, 0, 0, 0,18]
    [ 0,17, 0, 0, 0, 0,18, 0]
    [ 0, 0,13, 0, 0,17, 0, 0]
    [ 0, 0, 0, 9,18, 0, 0, 0]
    [ 0, 0, 0, 2,20, 0, 0, 0]
    [ 0, 0,20, 0, 0, 3, 0, 0]
    [ 0,14, 0, 0, 0, 0,11, 0]
    [19, 0, 0, 0, 0, 0, 0, 9]

    预期结果：true
     */

    public boolean checkXMatrix(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return true;
        }
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == j || (i + j) == (row - 1)) {
                    if (grid[i][j] == 0) {
                        return false;
                    }
                } else {
                    if (grid[i][j] != 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
