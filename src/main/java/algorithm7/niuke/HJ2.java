package algorithm7.niuke;

import java.util.Locale;
import java.util.Scanner;

/**
 * @Author: permission
 * @Date: 2023/1/11 19:10
 * @Version: 1.0
 * @ClassName: HJ2
 * @Description:
 * 描述
 * 写出一个程序，接受一个由字母、数字和空格组成的字符串，和一个字符，然后输出输入字符串中该字符的出现次数。（不区分大小写字母）
 *
 * 数据范围： 1 \le n \le 1000 \1≤n≤1000
 * 输入描述：
 * 第一行输入一个由字母、数字和空格组成的字符串，第二行输入一个字符（保证该字符不为空格）。
 *
 * 输出描述：
 * 输出输入字符串中含有该字符的个数。（不区分大小写字母）
 *
 * 示例1
 * 输入：
 * ABCabc
 * A
 * 复制
 * 输出：
 * 2
 *
 *
 */
public class HJ2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String str = in.nextLine();
        Character ch = in.nextLine().charAt(0);
        int res = c1(str, ch);
        System.out.println(res);
    }

    private static int c1(String str, Character ch) {
        int res;
        res = str.length();
        String s = str.toLowerCase();
        char c = Character.toLowerCase(ch);
        String s1 = s.replaceAll(String.valueOf(c), "");
        res = res - s1.length();
        return res;
    }
}
