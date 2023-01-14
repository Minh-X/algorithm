package algorithm7.niucode.nc.字符串;

import algorithm7.niucode.util.ScannerUtil;

import java.time.temporal.ValueRange;
import java.util.Stack;

/**
 * @Author: permission
 * @Date: 2023/1/13 15:11
 * @Version: 1.0
 * @ClassName: NC318
 * @Description: NC318 字符串的相邻字符去重
 */
public class NC318 {

    public static void main(String[] args) {
        String str = ScannerUtil.getString();
        String res = removeDuplicates(str);
        System.out.println(res);
        System.out.println(removeDuplicates3(str));
        String s = removeDuplicates4(str);
        System.out.println(removeDuplicates4(str));
    }

    //栈(StringBuilder实现) 如果栈为空,直接push,不为空判断栈顶和要push的值是否相等,相等删除栈顶的字符,不相等push
    private static String removeDuplicates4(String s) {
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

    private static String removeDuplicates3(String s) {
        Stack<Character> stack = new Stack();
        int i = 0;
        Character temp;
        while (i < s.length()) {
            if (!stack.isEmpty()) {
                temp = stack.pop();
                if (temp != s.charAt(i)) {
                    stack.push(temp);
                    stack.push(s.charAt(i));
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

    public static String removeDuplicates2(String s) {
        // write code here
        StringBuffer stack = new StringBuffer();
        int top = -1;
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (top >= 0 && stack.charAt(top) == ch) {
                stack.deleteCharAt(top);
                --top;
            } else {
                stack.append(ch);
                ++top;
            }
        }
        return stack.toString();
    }

    //leetcode 超时
    private static String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder(s);
        int i = 0;
        while (i < sb.length() - 1) {
            if (sb.charAt(i) == sb.charAt(i+1)) {
                // 先删除后面的，如果先删除前面的 后面的下标会变，代码如下
//                sb.deleteCharAt(i);
//                sb.deleteCharAt(i);
                sb.deleteCharAt(i+1);
                sb.deleteCharAt(i);
                i = 0;
            } else {
                i++;
            }
        }
        return sb.toString();
    }

}
