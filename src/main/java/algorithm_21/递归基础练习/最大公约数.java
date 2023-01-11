package algorithm_21.递归基础练习;

import java.util.Scanner;

/**
 * @author permission
 * @Date 2021 - 07 - 11 - 17:41
 * @package algorithm.递归基础练习
 * @Description:
 */
public class 最大公约数 {
    public int a1(int m, int n){
        if (n==0){
            return m;
        }
        return a1(n,m%n);
    }

    public static void main(String[] args) {
        最大公约数 obj = new 最大公约数();
        System.out.print("输入两个整数：");
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int result = obj.a1(m,n);
        System.out.println(result);
    }
}
