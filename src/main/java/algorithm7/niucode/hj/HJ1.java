package algorithm7.niucode.hj;

import java.util.Scanner;

/**
 * @Author: permission
 * @Date: 2023/1/11 18:41
 * @Version: 1.0
 * @ClassName: HJ1
 * @Description: 牛客 hj1
 */
public class HJ1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        c2(str);
    }

    static void c2(String str) {
        // 正则表达式实用性更强(str.split("\\s+"))
        String[] s = str.split(" ");
        System.out.println(s[s.length - 1].length());
    }

    static void c1(String str) {
        int total = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            if (' ' != (str.charAt(i))) {
                total++;
            } else {
                break;
            }
        }
        System.out.println(total);
    }
}
