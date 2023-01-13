package algorithm7.niucode.hj;

import java.util.Scanner;

/**
 * @Author: permission
 * @Date: 2023/1/12 14:42
 * @Version: 1.0
 * @ClassName: HJ13
 * @Description: 句子逆序
 */
public class HJ13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        c1(str);
    }

    private static void c1(String str) {
        String[] strArr = str.split(" ");
        for (int i = strArr.length - 1; i >= 0 ; i--) {
            System.out.print(strArr[i] + " ");
        }
    }
}
