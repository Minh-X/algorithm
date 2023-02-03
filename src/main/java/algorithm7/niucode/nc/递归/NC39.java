package algorithm7.niucode.nc.递归;

import java.util.Scanner;

/**
 * @Author: permission
 * @Date: 2023/2/3 0:21
 * @Version: 1.0
 * @ClassName: NC39
 * @Description: NC39 N皇后问题
 */
public class NC39 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int n = scanner.nextInt();
            int res = Nqueen(n);
            System.out.println(res);
        }
    }

    public static int Nqueen(int n) {
        int[] record = new int[n];
        return handle_recursion(0, n, record);
    }

    /**
     * @param i      行
     * @param n      n皇后
     * @param record 记录第i行放在第j列（record下标当作i）
     * @return
     */
    private static int handle_recursion(int i, int n, int[] record) {
        if (i == n) {
            return 1;
        }
        int res = 0;
        for (int j = 0; j < n; j++) {//尝试每一列
            if (isValid(i, j, record)) {//放在第j列合法，递归放下一行
                record[i] = j;//记录第i行放在哪一列
                res = res + handle_recursion(i + 1, n, record);
            }
        }

        return res;
    }

    //判断第i行放在第j列是否合法
    private static boolean isValid(int i, int j, int[] record) {
        for (int k = 0; k < i; k++) {//前i行放的皇后位置的j存在record[k]
            if (j == record[k]) {//j列已经放过了
                return false;
            } else if (Math.abs(record[k] - j) == Math.abs(i - k)) {//对角线位置
                return false;
            }
        }
        return true;
    }


}
