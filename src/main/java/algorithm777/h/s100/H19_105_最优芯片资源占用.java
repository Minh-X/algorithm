package algorithm777.h.s100;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: permission
 * @Date: 2023/2/10 23:30
 * @Version: 1.0
 * @ClassName: H19_105_最优芯片资源占用
 * @Description: 100
 */
public class H19_105_最优芯片资源占用 {

    public static void main(String[] args) {
/*
8
2
ACABA
期望：
11111000
11111111

8
2
ACBCB
期望：
11111000
11111111
 */
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();//芯片
        int n = scanner.nextInt();//板卡
        scanner.nextLine();
        String s = scanner.nextLine();//用户配置序列
        handle(m, n, s);
    }

    private static void handle(int m, int n, String s) {
        char[] chars = s.toCharArray();
        int[][] info = new int[n][m];

        int[] unUsed = new int[n];
        Arrays.fill(unUsed, m);

        for (int i = 0; i < chars.length; i++) {
            int capability;
            if (chars[i] == 'A') {
                capability = 1;
            } else if (chars[i] == 'B') {
                capability = 2;
            } else {
                capability = 8;
            }
            for (int j = 0; j < n; j++) {
                int unUsedJ = unUsed[j];
                if (unUsed[j] < capability) {
                    continue;
                }
                for (int k = m - unUsedJ; k < m - unUsedJ + capability; k++) {
                    info[j][k] = 1;
                    if (k == m - unUsedJ) {//已用容量只减一次，填1可能填多次（或者每次容量都减1）
                        unUsed[j] -= capability;
                    }
                }
                break;//只会在一块板上分配
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(info[i][j]);
            }
            System.out.println();
        }


    }

}
