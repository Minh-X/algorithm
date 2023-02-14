package algorithm777.h7.s200;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @Author: permission
 * @Date: 2023/2/13 23:15
 * @Version: 1.0
 * @ClassName: H10_
 * @Description: 200
 */
public class H10_计算网络信号_信号强度 {

    public static void main(String[] args) {
/*
6 5
0 0 0 -1 0 0 0 0 0 0 0 0 -1 4 0 0 0 0 0 0 0 0 0 0 -1 0 0 0 0 0
1 4
期望输出：2
 */
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int[][] infos = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                infos[i][j] = scanner.nextInt();
            }
        }

        int targetI = scanner.nextInt();
        int targetJ = scanner.nextInt();

        int res = handle(infos, m, n, targetI, targetJ);
        System.out.println(res);
    }

    private static int handle(int[][] infos, int m, int n, int targetI, int targetJ) {
        return bfs(infos, m, n, targetI, targetJ);

    }

    private static int bfs(int[][] infos, int m, int n, int targetI, int targetJ) {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (infos[i][j] > 0) {//出发点
                    queue.add(new int[]{i, j});
                }
            }
        }

        int[][] directs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!queue.isEmpty()) {
            int[] info = queue.poll();
            int curI = info[0];
            int curJ = info[1];
            int nextSignal = infos[curI][curJ] - 1;
            if (nextSignal == 0) {//下一步为0，不需要更新
                break;
            }
            for (int[] direct : directs) {
                int nextI = curI + direct[0];
                int nextJ = curJ + direct[1];
                if (nextI >= 0 && nextI < m && nextJ >= 0 && nextJ < n && infos[nextI][nextJ] == 0) {
                    infos[nextI][nextJ] = nextSignal;
                    queue.add(new int[]{nextI, nextJ});
                }
            }
        }
        return infos[targetI][targetJ];
    }

}
