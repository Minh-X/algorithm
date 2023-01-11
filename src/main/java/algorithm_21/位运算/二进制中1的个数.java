package algorithm_21.位运算;

import java.util.Scanner;

/**
 * 题目描述：
 * 请实现一个函数，输入一个整数，输出该数二进制表示中1的个数
 * 例：9的二进制表示为1001，有2位是1
 * @author permission
 * @Date 2021 - 06 - 08 - 10:29
 * @package algorithm.位运算
 * @Description: 二进制中1的个数
 */
public class 二进制中1的个数 {

    /**
     * 输入一个整数并输出其二进制表示
     * 用于判断其二进制表示中1的个数
     * @return 一个整数
     */
    public int creatInt(){
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        String string = Integer.toString(N,2);
        System.out.println("该整数二进制表示为：" + string);
        return N;
    }

    /**
     * 题解1：
     * 将 1 逐位左移与 N 相与，判断 N 的对应位上是否为1
     */
    public void find1_1(int N){
        int intLength = 32;
        int count = 0;
        for (int i = 0; i < intLength; i++) {
            //判断第i位(从右往左)是否为1，为1 count++
            if ((N&(1<<i)) == (1<<i)){
                count++;
            }
        }
        System.out.println(count);
    }

    /**
     * 题解2：
     * 将 N 逐位右移与 1 相与，判断 N 的对应位上是否为1
     */
    public void find1_2(int N){
        int intLength = 32;
        int count = 0;
        for (int i = 0; i < intLength; i++) {
            if ((1&(N>>i)) == 1){
                count++;
            }
        }
        System.out.println(count);
    }

    /**
     * 题解3：
     * 将 N 与（N-1）相与，每进行一次与运算，可将低位上（位于最右边）的一个1消除
     * 例：
     * 1010 & 1001 = 1000
     */
    public void find1_3(int N){
        int count = 0;
        while (N!=0){
            N = N&(N-1);
            count++;
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        二进制中1的个数 object = new 二进制中1的个数();
        int N =object.creatInt();
        System.out.print("方法1结果：");
        object.find1_1(N);
        System.out.print("方法2结果：");
        object.find1_2(N);
        System.out.print("方法3结果：");
        object.find1_3(N);
    }
}
