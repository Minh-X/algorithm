package algorithm7.leetcode.dfs_and_bfs;

/**
 * @Author: permission
 * @Date: 2023/2/3 21:04
 * @Version: 1.0
 * @ClassName: LC200
 * @Description: 200. 岛屿数量
 */
public class LC200 {

    public static void main(String[] args) {
        char[][] grid =
                {
                        {'1', '1', '0', '0', '0'},
                        {'1', '1', '0', '0', '0'},
                        {'0', '0', '1', '0', '0'},
                        {'0', '0', '0', '1', '1'}
                };
        int res = numIslands(grid);
        System.out.println(res);
    }

    public static int numIslands(char[][] grid) {
        return numIslands_Handle_DFS(grid);
    }

    private static int numIslands_Handle_DFS(char[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {//发现一个岛屿，将它相邻的1全部感染
                    res++;
                    infect_DFS(i, j, grid);
                }

            }
        }
        return res;
    }

    private static void infect_DFS(int i, int j, char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        if (i < 0 || i >= row || j < 0 || j >= col || grid[i][j] == '0') {//不需要感染的情况，越界或者非1（不是岛屿）
            return;
        }
        grid[i][j] = '0';//感染
        infect_DFS(i - 1, j, grid);
        infect_DFS(i + 1, j, grid);
        infect_DFS(i, j - 1, grid);
        infect_DFS(i, j + 1, grid);
    }

}
