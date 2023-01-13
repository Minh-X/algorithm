package algorithm7.niucode.hj;

import java.util.Scanner;

/**
 * @Author: permission
 * @Date: 2023/1/12 14:33
 * @Version: 1.0
 * @ClassName: HJ12
 * @Description: 字符串反转
 */
public class HJ12 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        c1(str);
    }

    private static void c1(String str) {
        StringBuilder sb = new StringBuilder(str);
        System.out.println(sb.reverse());
    }
}
