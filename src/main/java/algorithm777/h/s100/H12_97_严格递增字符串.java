package algorithm777.h.s100;

import java.util.Scanner;

/**
 * @Author: permission
 * @Date: 2023/2/10 12:11
 * @Version: 1.0
 * @ClassName: H12_97_严格递增字符串
 * @Description: 100
 */
public class H12_97_严格递增字符串 {

    public static void main(String[] args) {
/*
AAAABA
期望：1

BAAAAA
期望：1
 */
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int res = handle(s);
        System.out.println(res);
    }

    /*
            从前往后替换后置A
            从后往前替换前置B
            取最小的替换次数
     */
    private static int handle(String s) {
        char[] chars = s.toCharArray();
        int res = 0;
        boolean flag = false;
        for (int i = 0; i < chars.length; i++) {
            if ('B' == chars[i] || flag) {
                flag = true;
                if ('A' == chars[i]) {
                    res++;
                }
            }
        }
        flag = false;
        int res1 = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            if ('A' == chars[i] || flag) {
                flag = true;
                if ('B' == chars[i]) {
                    res1++;
                }
            }
        }
        return Math.min(res, res1);
    }

}
