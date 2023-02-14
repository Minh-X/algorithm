package algorithm777.h7.s200;

import java.util.Scanner;

/**
 * @Author: permission
 * @Date: 2023/2/14 17:46
 * @Version: 1.0
 * @ClassName: H17_数字加减游戏
 * @Description: 200
 */
public class H17_数字加减游戏 {

    public static void main(String[] args) {
/*
1 10 5 2
期望输出：1

11 33 4 10
期望输出：2
 */
        Scanner scanner = new Scanner(System.in);
        int s = scanner.nextInt();
        int t = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int res = handle(s, t, a, b);
        System.out.println(res);
    }

    /*
            s变成t（输入的s比能通过a、b变成t）
                b能用无限次，求a的最少次数

            s + a*X + b*Y = t
            s - t + a*X = b*Y
            (s - t + a*X) / b = Y   穷举X，当结果Y为整数时即为答案（X，Y可以为负数）
     */
    private static int handle(int s, int t, int a, int b) {
        int X = 0;
        while (true) {

            int p1 = (s - t + a * X) % b;
            int p2 = (s - t + a * (-X)) % b;
            if (p1 == 0 || p2 == 0) {
                return Math.abs(X);
            }
            X++;
        }
    }
}