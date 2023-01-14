package algorithm7.leetcode.字符串;

import java.util.Scanner;

/**
 * @Author: permission
 * @Date: 2023/1/13 16:50
 * @Version: 1.0
 * @ClassName: LC1047
 * @Description: 删除字符串中的所有相邻重复项
 */
public class LC1047 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(s);
        String res = removeDuplicates(s);
        System.out.println(res);
    }

    public static String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder();
        int top = -1;// -1代表栈为空, >=0 表示栈顶下标(在sb中)
        int i = 0;//字符串s下标
        while (i < s.length()) {
            if (top >=0 && s.charAt(i) == sb.charAt(top)) {
                sb.deleteCharAt(top);
                top--;
            } else {
                sb.append(s.charAt(i));
                top++;
            }
            i++;
        }
        return sb.toString();
    }
}
