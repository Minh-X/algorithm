package algorithm7.niucode.hj;

import java.util.Scanner;

/**
 * @Author: permission
 * @Date: 2023/1/12 14:19
 * @Version: 1.0
 * @ClassName: HJ11
 * @Description: 数字颠倒
 */
public class HJ11 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int anInt = scanner.nextInt();
        c1(anInt);
    }

    private static void c1(int anInt) {
        StringBuilder sb = new StringBuilder(String.valueOf(anInt)).reverse();
        System.out.println(sb);
    }

}
