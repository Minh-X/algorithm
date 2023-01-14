package algorithm7.niucode.util;

import java.util.Scanner;

/**
 * @Author: permission
 * @Date: 2023/1/13 15:20
 * @Version: 1.0
 * @ClassName: ScannerUtil
 * @Description:
 */
public class ScannerUtil {

    /**
     * 获取从键盘输入的一个字符串
     * @return
     */
    public static String getString() {
        Scanner scanner = new Scanner(System.in);
        String str = null;
        if (scanner.hasNextLine()) {
            str = scanner.nextLine();
        }
        return str;
    }

}
