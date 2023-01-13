package algorithm7.niucode.hj;

import java.util.Scanner;

/**
 * @Author: permission
 * @Date: 2023/1/11 21:23
 * @Version: 1.0
 * @ClassName: HJ4
 * @Description: 字符串分隔
 */
public class HJ4 {

    private static final int SPLITNUM = 8;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String str = scanner.nextLine();
            if (!str.isEmpty()) {
                mySplit(str);
            }
        }
    }

    private static void mySplit(String str) {
        while (str.length() > SPLITNUM) {
            String s = str.substring(0, SPLITNUM);
            System.out.println(s);
            str = str.substring(SPLITNUM);
        }
        if (str.length() <= SPLITNUM && str.length() > 0) {
            str = str + "00000000";
            String s = str.substring(0, 8);
            System.out.println(s);
        }
    }


}
