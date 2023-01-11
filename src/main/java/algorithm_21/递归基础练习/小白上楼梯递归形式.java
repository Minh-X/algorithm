package algorithm_21.递归基础练习;

import java.util.Scanner;

/**
 * 小白上楼梯
 * @author permission
 * @Date 2021 - 07 - 13 - 17:20
 * @package algorithm.递归基础练习
 * @Description:
 */
public class 小白上楼梯递归形式 {
    /**
     *
     * @param n 楼梯高度
     * @return
     */
    public int f1(int n){
        if (n==0) return 1;
        if (n==1) return 1;
        if (n==2) return 2;
        return f1(n-1) + f1(n-2) + f1(n-3);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        小白上楼梯递归形式 obj = new 小白上楼梯递归形式();
        int result = obj.f1(n);
        System.out.println(result);
    }
}
