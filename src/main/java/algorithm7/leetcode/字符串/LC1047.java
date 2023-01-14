package algorithm7.leetcode.字符串;

import java.util.Scanner;
import java.util.Stack;

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

    private static String removeDuplicates(String s) {
        return s3(s);
    }

    //伪栈（sb实现栈效果）   效率高
    public static String s3(String s) {
        StringBuilder sb = new StringBuilder();
        int top = -1;// -1代表栈为空, >=0 表示栈顶下标(在sb中)
        int i = 0;//字符串s下标
        while (i < s.length()) {
            if (top >= 0) {
                if (s.charAt(i) != sb.charAt(top)) {
                    sb.append(s.charAt(i));
                    top++;
                } else {
                    sb.deleteCharAt(top);
                    top--;
                }
            } else {
                sb.append(s.charAt(i));
                top++;
            }
            i++;
        }
        return sb.toString();
    }

    //栈
    public static String s1(String s) {
        Stack<Character> stack = new Stack();
        int i = 0;
        Character temp;
        while (i < s.length()) {
            if (!stack.isEmpty()) {
                if (stack.peek() != s.charAt(i)) {
                    stack.push(s.charAt(i));
                } else {
                    stack.pop();
                }
            } else {
                stack.push(s.charAt(i));
            }
            i++;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    //StringBuilder下标
    public static String s2(String s) {
        StringBuilder sb = new StringBuilder(s);
        int i = 0;
        while (i < sb.length() - 1) {
            if (sb.charAt(i) == sb.charAt(i + 1)) {
                // 先删除后面的，如果先删除前面的 后面的下标会变，代码如下
//                sb.deleteCharAt(i);
//                sb.deleteCharAt(i);
                sb.deleteCharAt(i + 1);
                sb.deleteCharAt(i);
                i--;
                if (i < 0) {
                    i = 0;
                }
            } else {
                i++;
            }
        }
        return sb.toString();
    }
}
