package algorithm777.h.s100;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: permission
 * @Date: 2023/2/6 16:17
 * @Version: 1.0
 * @ClassName: H3_统计友好度最大值
 * @Description: 【2023 Q1 | 100分】
 */
public class H3_82_统计友好度最大值 {


    public static void main(String[] args) {
        /*
1 1 0 1 2 1 0
期望：3

0 1 0
期望：1
         */
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] str = s.split(" ");
        handle(str);
    }

    private static void handle(String[] arry) {
        int l;
        int r;
        int[] res = new int[arry.length];
        for (int i = 0; i < arry.length; i++) {
            l = i;
            r = i;
            if ("0".equals(arry[i])) {
                while (--l >= 0) {
                    if ("1".equals(arry[l])) {
                        res[i]++;
                    } else {
                        break;
                    }
                }
                while (++r <= arry.length - 1) {
                    if ("1".equals(arry[r])) {
                        res[i]++;
                    } else {
                        break;
                    }
                }
            }
        }
        System.out.println(Arrays.stream(res).max().getAsInt());
    }
}
