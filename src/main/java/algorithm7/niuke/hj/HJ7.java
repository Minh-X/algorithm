package algorithm7.niuke.hj;

import java.util.Scanner;

/**
 * @Author: permission
 * @Date: 2023/1/12 1:56
 * @Version: 1.0
 * @ClassName: HJ7
 * @Description:
 */
public class HJ7 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextDouble()) {
            double dou = scanner.nextDouble();
            c1(dou);
        }
    }

    private static void c1(double dou) {
        System.out.println(Math.round(dou));
    }

}
