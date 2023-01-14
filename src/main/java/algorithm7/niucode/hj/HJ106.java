package algorithm7.niucode.hj;

import java.util.Scanner;

/**
 * @Author: permission
 * @Date: 2023/1/14 3:20
 * @Version: 1.0
 * @ClassName: HJ106
 * @Description: 字符逆序
 */
public class HJ106 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String str = in.nextLine();

        System.out.println(f1(str));
    }

    private static String f1(String str) {
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString();
    }
}
