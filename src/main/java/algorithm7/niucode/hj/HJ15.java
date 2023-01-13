package algorithm7.niucode.hj;

import java.util.Scanner;

/**
 * @Author: permission
 * @Date: 2023/1/12 15:13
 * @Version: 1.0
 * @ClassName: HJ15
 * @Description: 求int型正整数在内存中存储时1的个数
 */
public class HJ15 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int anInt = scanner.nextInt();
        c1(anInt);
    }

    // 和 1 进行与运算，结果为1说明最低位为1，然后右移一位再判断第二位
    private static void c1(int anInt) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if ((anInt & 1) == 1) {
                res ++ ;
            }
            anInt = anInt >> 1;
        }
        System.out.println(res);
    }

}
