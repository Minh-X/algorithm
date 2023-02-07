package algorithm777.h.s200;

import java.util.Scanner;

/**
 * @Author: permission
 * @Date: 2023/2/6 23:53
 * @Version: 1.0
 * @ClassName: H2_荒地建设电站_区域发电量统计
 * @Description: 200
 */
public class H2_83_荒地建设电站_区域发电量统计 {

    public static void main(String[] args) {
        /*
2 5 2 6
1 3 4 5 8
2 3 6 7 1
期望输出：4

2 5 1 6
1 3 4 5 8
2 3 6 7 1
期望输出：3
         */

        Scanner scanner = new Scanner(System.in);
//        int row = 2;
//        int col = 5;
//        int sideLen = 2;
//        int targetArea = 6;
//        int[][] filed = {{1, 3, 4, 5, 8}, {2, 3, 6, 7, 1}};
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        int sideLen = scanner.nextInt();
        int targetArea = scanner.nextInt();
        int[][] filed = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                filed[i][j] = scanner.nextInt();
            }
        }
        int res = handle(filed, sideLen, targetArea, row, col);
        System.out.println(res);
    }

    private static int handle(int[][] filed, int sideLen, int targetAera, int row, int col) {
        int[][] prefix = new int[row + 1][col + 1];
        //构建二维前缀数组
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                prefix[i][j] = filed[i - 1][j - 1] + prefix[i - 1][j] + prefix[i][j - 1] - prefix[i - 1][j - 1];
            }
        }

        int areaNum = 0;//可作为建站点的数量
        for (int i = sideLen; i <= row; i++) {
            for (int j = sideLen; j <= col; j++) {
//                for (int k = 1; k <= row && k <= col; k++) //k固定为sideLen
                int temp = prefix[i][j] - prefix[i - sideLen][j] - prefix[i][j - sideLen] + prefix[i - sideLen][j - sideLen];
                if (temp >= targetAera) {
                    areaNum++;
                }
            }
        }
        return areaNum;
    }

}
