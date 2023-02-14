package algorithm777.h7.s200;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: permission
 * @Date: 2023/2/12 18:42
 * @Version: 1.0
 * @ClassName: H30_农场施肥_不爱施肥的小布
 * @Description: 2023Q1
 */
public class H30_农场施肥_不爱施肥的小布 {

    public static void main(String[] args) {
                /*
5 7
5 7 9 15 10
期望输出：9
         */
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();//n天
        int[] field = new int[m];
        for (int i = 0; i < m; i++) {
            field[i] = scanner.nextInt();
        }
        long start = System.currentTimeMillis();
        int res = handle(m, n, field);
        long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - start));
        System.out.println("至少：" + res);
    }

    private static int handle(int m, int n, int[] fields) {
        return binary_search(m, n, fields);
    }

    private static int binary_search(int m, int n, int[] fields) {
        Arrays.sort(fields);
        int minK = fields[0];
        int maxK = fields[m - 1];

        int ans = -1;
        while (maxK - minK > 1) {
            int curK = (maxK + minK) / 2;
            int needDays = cal(curK, fields);
            if (needDays > n) {
                minK = curK;
            } else {
                ans = curK;
                maxK = curK;
            }
        }
        return ans;
    }

    //判断效能为k时，所需总天数
    public static int cal(int k, int[] fields) {
        int days = 0;
        for (int i = 0; i < fields.length; i++) {
            days += Math.ceil(fields[i] / (double) k);
        }
        return days;
    }

}
