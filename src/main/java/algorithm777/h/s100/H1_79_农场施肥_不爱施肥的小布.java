package algorithm777.h.s100;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: permission
 * @Date: 2023/2/6 0:50
 * @Version: 1.0
 * @ClassName: H1
 * @Description: 100
 */
public class H1_79_农场施肥_不爱施肥的小布 {

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

        System.out.println("m：" + m);
        System.out.println("n：" + n);
        for (int i : field) {
            System.out.print(i + " ");
        }

        long start = System.currentTimeMillis();

//        for (int i = 0; i < Math.pow(10, 9); i++) {
//            handle(m, n, field);
//        }
        long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - start));
        int res = handle(m, n, field);
        int res2 = t(m, n, field);
        System.out.println(res);
        System.out.println("有bug：" + res2);
    }

    private static int handle(int m, int n, int[] field) {
        double minK = 0.0;
        while (true) {
            minK++;
            int minDay = 0;
            for (int i = 0; i < m; i++) {
                int ceil = (int) Math.ceil(field[i] / minK);
                System.out.print(ceil + "   ");
                minDay = (minDay + ceil);
            }
            System.out.println();
            if (minK == 9) {
                System.out.println(minDay + "----");
            }
            if (minDay <= n) {
                return (int) minK;
            }
        }
    }


    public static int t(int m, int n, int[] fields) {
        // 最少天数小于果林大小可直接返回-1
        if (n < m) {
            System.out.println(-1);
            return -1;
        }

        //排序找到最大最小值
        Arrays.sort(fields);
        int left = fields[0];
        int right = fields[fields.length - 1];
        int result = -1;

        while (left + 1 < right) {
            //取中间位置的值作为效能k，这里的k取得是其在数组中的index
            int k = (int) Math.ceil((double) (left + right) / 2);

            int res = cal(k, fields);

            if (res - n > 0) {
                left = k;
            } else {
                result = k;
                right = k;
            }
        }
        return result;
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

