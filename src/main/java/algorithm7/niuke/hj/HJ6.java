package algorithm7.niuke;

import java.util.Scanner;

/**
 * @Author: permission
 * @Date: 2023/1/11 22:54
 * @Version: 1.0
 * @ClassName: HJ6
 * @Description: 质因子
 */
public class HJ6 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            c3(n);
        }
    }
    // 优化超时
    static void c3(int num) {
        int k = (int) Math.sqrt(num);
        for (long i = 2; i <= k; ++i) {
            while (num % i == 0) {
                System.out.print(i + " ");
                num /= i;
            }
        }
        // 输出最后一个数 如：当n=2000000014，输出 1000000007
        System.out.println(num == 1 ? "": num+" ");
    }

    // n大的话超时 如：n=2000000014
    private static void c2(int n) {
        for (int i = 2; i <= n; i++) {
            while (n % i == 0) {
                System.out.print(i + " ");
                n = n / i;
            }
        }
    }

    // n大的话超时 如：n=2000000014
    public static void c1(long num){
        for (int i= 2;i <= num; i++){
            if (num % i==0){
                System.out.print(i + " ");
                c1(num/i);
                break;
            }
            if (i==num){
                System.out.print( i + "");
            }
        }
    }

}
