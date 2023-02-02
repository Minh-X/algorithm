package algorithm7.niucode.nc.栈;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @Author: permission
 * @Date: 2023/1/22 2:57
 * @Version: 1.0
 * @ClassName: NC52
 * @Description: NC52 有效括号序列
 */
public class NC52 {

    public static void main(String[] args) {
        System.out.println(isValid("()())("));
    }

    public static boolean isValid (String s) {
        // write code here
        if (s.length() == 0 || s == null) {
            return false;
        }
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        stack.push(chars[0]);
        for (int i = 1; i < chars.length; i++) {
            if (stack.isEmpty()) {
                stack.push(chars[i]);
            } else if (stack.peek() == map.get(chars[i])) {
                stack.pop();
                continue;
            } else {
                stack.push(chars[i]);
            }
        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }

}
