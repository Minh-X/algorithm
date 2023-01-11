package algorithm_21.递归基础练习;

import java.util.Scanner;

/**
 * 求 n 的阶乘
 *
 * @author permission
 * @Date 2021 - 06 - 18 - 21:22
 * @package algorithm.递归基础
 * @Description:
 */
public class 阶乘 {


    static int f1(int n) {
        if (n<=1) {
            return 1;
        }
        return n * f1(n-1);
    }

    /**
     * 求 n 的阶乘
     */
    public int factorial(int n){
        if (n==1){
            return 1;
        }
        return n * factorial(n-1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        N = new 阶乘().factorial(N);
        System.out.println(N);
        System.out.println(f1(8));
    }
}
