package algorithm7.niucode.hj;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * @Author: permission
 * @Date: 2023/1/21 15:16
 * @Version: 1.0
 * @ClassName: HJ20
 * @Description: HJ20 密码验证合格程序
 */
public class HJ20 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String str;
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            str = in.nextLine();
            isOK2(str);
        }
    }

    private static void isOK2(String str) {
        String res = "OK";
        char[] strs = str.toCharArray();
        //1.密码长度大于8
        if (strs.length < 8) {
            res = "NG";
        }
        int[] chek = new int[4];
        //2.包括大小写字母，数字，其他字符（4种中3种以上）
        for (int i = 0; i < strs.length; i++) {
            if (strs[i] >= '0' && strs[i] <= '9') {
                chek[0] = 1;
            } else if (strs[i] >= 'a' && strs[i] <= 'z') {
                chek[1] = 1;
            } else if (strs[i] >= 'A' && strs[i] <= 'Z') {
                chek[2] = 1;
            } else {
                chek[3] = 1;
            }
        }
        int count = 0;
        for (int i = 0; i < chek.length; i++) {
            if (chek[i] == 1) {
                count++;
            }
        }
        if (count < 3) {
            res = "NG";
        }
        //3.不能有长度大于2的包含公共元素的字串重复
        String sub;
        for (int i = 0; i < str.length() - 3; i++) {
            sub = str.substring(i, i + 3);
            int a = str.indexOf(sub, i + 3);
            if (a > 0) {
                res = "NG";
            }
        }
        System.out.println(res);
    }

    private static void isOK(String str) {
        String res = "OK";
        //1.密码长度大于8
        if (str.length() < 8) {
            res = "NG";
            System.out.println(res);
            return;
        }
        boolean hasNum = false;
        boolean hasBig = false;
        boolean hasSmall = false;
        boolean hasChar = false;
        int count = 0;
        char ch;
        //2.包括大小写字母，数字，其他字符（4种种3种以上）
        for (int i = 0; i < str.length(); i++) {
            ch = str.charAt(i);
            boolean b1 = Pattern.matches("[0-9]", String.valueOf(ch));
            if (b1 && !hasNum) {
                hasNum = true;
                count++;
                continue;
            }
            boolean b2 = Pattern.matches("[a-z]", String.valueOf(ch));
            if (b2 && !hasSmall) {
                hasSmall = true;
                count++;
                continue;
            }
            boolean b3 = Pattern.matches("[A-Z]", String.valueOf(ch));
            if (b3 && !hasBig) {
                hasBig = true;
                count++;
                continue;
            }
            boolean b4 = Pattern.matches("\\W", String.valueOf(ch));
            if (b4 && !hasChar) {
                hasChar = true;
                count++;
                continue;
            }
        }
        if (count < 3) {
            res = "NG";
        }
        //3.不能有长度大于2的包含公共元素的字串重复
        String substring1;
        int k;
        for (int i = 0; i < str.length() - 3; i++) {
            substring1 = str.substring(i,i+3);
            k = str.indexOf(substring1, i+3);
            if (k > i) {
                res = "NG";
            }
        }
        System.out.println(res);
    }
}
