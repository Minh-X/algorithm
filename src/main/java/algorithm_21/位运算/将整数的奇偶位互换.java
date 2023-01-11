package algorithm_21.位运算;

import java.util.Scanner;

/**
 * 将整数的奇偶位互换
 * @author permission
 * @Date 2021 - 06 - 09 - 14:22
 * @package algorithm.位运算
 * @Description:
 */
public class 将整数的奇偶位互换 {
    /**
     * 题解：
     * 和 1010 1010 1010 1010 1010 1010 1010 1010 进行与运算，取出偶数位
     * 和 0101 0101 0101 0101 0101 0101 0101 0101 进行与运算，取出奇数位
     * 两个与的结果分别右移一位，左移一位再进行异或运算，得到答案
     * @param N
     */
    public void swap_222222(int N){
        System.out.println("该数二进制表示为" + Integer.toString(N,2));
        //1010B = 0xa
        int ou = N&0xaaaaaaaa;
        //0b0101 = 0x5
        int ji = N&0x55555555;
        int result = ou>>1^ji<<1;
        System.out.println("结果二进制表示为" + Integer.toString(result,2));
        System.out.println("十进制结果：" + result);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("输入一个整数：");
        int N = scanner.nextInt();
        new 将整数的奇偶位互换().swap_222222(N);
    }
}
