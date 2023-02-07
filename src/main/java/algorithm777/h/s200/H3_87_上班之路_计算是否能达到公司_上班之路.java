package algorithm777.h.s200;

import java.util.Scanner;

/**
 * @Author: permission
 * @Date: 2023/2/7 16:30
 * @Version: 1.0
 * @ClassName: H3_87_上班之路
 * @Description: 计算是否能达到公司 /上班之路
 */
public class H3_87_上班之路_计算是否能达到公司_上班之路 {

    public static void main(String[] args) {
/*

2 0
5 5
. . S . .
* * * * .
T . . . .
* * * * .
. . . . .
期望输出：YES

1 1
5 5
. . S . .
* * * * *
T . . . .
* * * * .
. . . . .
期望输出：YES

 */

        Scanner scanner = new Scanner(System.in);
        int turn = scanner.nextInt();
        int remove = scanner.nextInt();
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        scanner.nextLine();
        char[][] graph = new char[row][col];
        for (int i = 0; i < row; i++) {
            String s = scanner.nextLine();
            s = s.replaceAll(" ", "");
            graph[i] = s.toCharArray();
        }
        int startI = 0;
        int startJ = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (graph[i][j] == 'S') {
                    startI = i;
                    startJ = j;
                    break;
                }
            }
        }

        boolean res = handle(graph, turn, remove, row, col, startI, startJ);
        System.out.println(res == true ? "YES" : "NO");
    }

    private static boolean handle(char[][] graph, int turn, int remove, int row, int col, int startI, int startJ) {
        boolean[][] v = new boolean[row][col];
        return dfs(graph, v, turn, remove, row, col, startI, startJ, -1);
    }

    static int[][] directs = {{-1, 0, 0}, {1, 0, 1}, {0, -1, 2}, {0, 1, 3}};//四个方向，上下左右

    private static boolean dfs(char[][] graph, boolean[][] visited, int turn, int remove, int row, int col, int i, int j, int last_Direct) {
        if (graph[i][j] == 'T' && turn >= 0 && remove >= 0) {
            return true;
        }
        visited[i][j] = true;//标记为已经走过
        for (int[] dir : directs) {
            int nextI = i + dir[0];
            int nextJ = j + dir[1];
            int next_Direct = dir[2];
            int nextTurn = turn;//需要这个变量是因为先转向，再破壁，可能转向了发现需要立即破壁却无法破壁（remove<0），如果直接turn--（表示转向，但是却无法破壁，实际上转向无效）
            int nextRemove = remove;//需要这个变量是因为先转向，再破壁，可能转向了发现需要立即破壁却无法破壁（remove<0），如果直接turn--（表示转向，但是却无法破壁，实际上转向无效）

            if (nextI < 0 || nextI > row - 1 || nextJ < 0 || nextJ > col - 1 || visited[nextI][nextJ] == true) {//越界或者已经走过
            } else {
                if (last_Direct != -1 && last_Direct != next_Direct) {//不是第一步（起始），且下一步方向改变
                    nextTurn = nextTurn - 1;
                    if (nextTurn < 0) {//turn次数不够
                        continue;
                    }
                }
                if (graph[nextI][nextJ] == '*') {//需要破壁
                    nextRemove = nextRemove - 1;
                    if (nextRemove < 0) {
                        continue;
                    }
                }

                boolean r = dfs(graph, visited, nextTurn, nextRemove, row, col, nextI, nextJ, next_Direct);
                if (r) {
                    return true;
                }
            }
        }
        return false;
    }

}
