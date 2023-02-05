package algorithm7.leetcode.队栈;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

/**
 * @Author: permission
 * @Date: 2023/1/14 18:06
 * @Version: 1.0
 * @ClassName: LC20
 * @Description: 20. 有效的括号
 */
public class LC20 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
//        return handle1(s);
//        return handle2(s);
        return handle3(s);
    }

    /*
            再刷20230205
     */
    private static boolean handle3(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Character> map = new HashMap<>();//题中一共三种扩号 () [] {}
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        Stack<Character> stack = new Stack<>();
        for (char ch : chars) {
//            if (!stack.isEmpty() && map.get(stack.peek()) != null && map.get(stack.peek()) == ch) {//这里注意要判断map.get(stack.peek()) != null，不然会空指针（右扩号没放进map）
            if (!stack.isEmpty() && map.getOrDefault(stack.peek(), '0') == ch) {//这里注意要判断map.get(stack.peek()) != null，不然会空指针（右扩号没放进map）
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }


    /*

给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
每个右括号都有一个对应的相同类型的左括号。

            输入：s = "()"
            输出：true

            输入：s = "()[]{}"
            输出：true

            输入：s = "(]"
            输出：false
     */

    public static boolean handle1(String s) {
        int len = s.length();
        // 括号数要成对
        if (len % 2 != 0) {
            return false;
        }

        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {//左扩号压栈,右括号出栈判断是否匹配
                if (stack.isEmpty() || stack.peek() != map.get(ch)) {//peek方法返回栈顶元素但不删除
                    return false;
                } else {
                    // 匹配成功,出栈
                    stack.pop();
                }
            } else {
                stack.push(ch);
            }
        }
        //最后栈空,说明字符串有效
        return stack.isEmpty();
    }

    /*
            LC评论区（妙）
     */
    public static boolean handle2(String s) {
        while (s.contains("()") || s.contains("{}") || s.contains("[]")) {
            s = s.replace("()", "");
            s = s.replace("[]", "");
            s = s.replace("{}", "");
        }
        return s == "";
    }

}
