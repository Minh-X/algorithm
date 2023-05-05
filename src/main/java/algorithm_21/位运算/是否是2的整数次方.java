package algorithm_21.位运算;


import java.util.Scanner;

/**
 * 一条语句判断一个整数是不是2的整数次方
 * @author permission
 * @Date 2021 - 06 - 09 - 14:05
 * @package algorithm.位运算
 * @Description:
 */
public class 是否是2的整数次方 {
    /**
     * 题解：
     * 若该整数的二进制表示只有一个1，则是2的整数次方
     */
    public void power_2(int N){
        //消除二进制表示的一个1
        if ((N&(N-1)) == 0){
            System.out.println("是");
        } else {
            System.out.println("不是");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("输入一个整数，判断是不是2的整数次方：");
        int N = scanner.nextInt();
        new 是否是2的整数次方().power_2(N);
    }
}
