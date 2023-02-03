package algorithm_21.递归基础练习;

import java.util.Scanner;

/**
 * @Author: permission
 * @Date: 2023/2/3 0:57
 * @Version: 1.0
 * @ClassName: N皇后问题
 * @Description: N皇后问题
 */
public class N皇后问题 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int n = scanner.nextInt();
            int res = Nqueen(n);
            System.out.println(res);
        }
    }

    /*
        返回数量
     */
    private static int Nqueen(int n) {
        int[] record = new int[n];
        return handle(0, n, record);//0到n行
    }

    private static int handle(int i, int n, int[] record) {
        if (i == n) {
            return 1;
        }
        int res = 0;
        for (int j = 0; j < n; j++) {
            if (isValid(i, j, record)) {//合法
                record[i] = j;
                res += handle(i + 1, n, record);
            }
        }
        return res;
    }

    private static boolean isValid(int i, int j, int[] record) {
        for (int k = 0; k < i; k++) {//判断现在要放的位置和前i行已经放好的是否冲突
            if (j == record[k] || Math.abs(j - record[k]) == Math.abs(i - k)) {
                return false;
            }
        }
        return true;
    }

}
