package algorithm7.leetcode;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: permission
 * @Date: 2023/1/24 14:04
 * @Version: 1.0
 * @ClassName: LC200
 * @Description: 200. 岛屿数量
 */
public class LC200 {

    public static void main(String[] args) {
        //[['1','1','0','0','0'],['1','1','0','0','0'],['0','0','1','0','0'],['0','0','0','1','1']]
        //[["1","1","0","0","0"],["1","1","0","0","0"],["0","0","1","0","0"],["0","0","0","1","1"]]
        char[][] c2 = new char[4][5];
        c2[0] = new char[]{'1', '1', '0', '0', '0'};
        c2[1] = new char[]{'1', '1', '0', '0', '0'};
        c2[2] = new char[]{'0', '0', '1', '0', '0'};
        c2[3] = new char[]{'0', '0', '0', '1', '1'};

        char[][] c = new char[4][5];
        c[0] = new char[]{'1', '1', '1', '1', '0'};
        c[1] = new char[]{'1', '1', '0', '1', '0'};
        c[2] = new char[]{'1', '1', '0', '0', '0'};
        c[3] = new char[]{'0', '0', '0', '0', '0'};
        int n = numIslands(c2);
        System.out.println(n);
    }

    public static int numIslands(char[][] grid) {
//        return numIslands_Handle_DFS(grid);
        return numIslands_Handle_BFS(grid);
    }

    /*
            BFS
     */
    private static int numIslands_Handle_BFS(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int res = 0;
        int row = grid.length;
        int col = grid[0].length;

        Integer i1;
        Integer j1;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    queue.offer(i * 500 + j);
                    res++;
                }
                while (!queue.isEmpty()) {
                    Integer p = queue.poll();
                    i1 = p/500;//row
                    j1 = p%500;//col
                    System.out.print(i1 + " ");
                    System.out.print(j1);
                    System.out.println();
                    grid[i1][j1] = '0';//感染
                    if (j1 - 1 >= 0 && grid[i1][j1-1] == '1') {//判断上面
                        queue.offer(i1 * 500 + j1 - 1);
                    }
                    if (j1 + 1 < col && grid[i1][j1+1] == '1') {//判断下面
                        queue.offer(i1 * 500 + j1 + 1);
                    }
                    if (i1 - 1 >= 0 && grid[i1-1][j1] == '1') {//判断左边
                        queue.offer((i1 - 1) * 500 + j1);
                    }
                    if (i1 + 1 < row && grid[i1+1][j1] == '1') {//判断右边
                        queue.offer((i1 + 1) * 500 + j1);
                    }
                }
            }
        }
        return res;
    }


    /*
            DFS
            时间复杂度：O(nm)
     */
    private static int numIslands_Handle_DFS(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int res = 0;
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    res++;//岛屿数量+1
                    DFS(grid, i, j);//感染
                }
            }
        }
        return res;
    }

    private static void DFS(char[][] grid, int i, int j) {
        int row = grid.length;
        int col = grid[0].length;
        if (i < 0 || i >= row || j < 0 || j >= col || grid[i][j] == '0') {
            //下标越界或者已经被感染过了（包括本来是0，不需要感染）
            return;
        }
        grid[i][j] = '0';//感染
        DFS(grid, i, j - 1);
        DFS(grid, i, j + 1);
        DFS(grid, i - 1, j);
        DFS(grid, i + 1, j);
    }

}
