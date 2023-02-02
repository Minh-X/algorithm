package algorithm7.leetcode.剑指Offer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.function.Predicate;

/**
 * @Author: permission
 * @Date: 2023/2/2 2:10
 * @Version: 1.0
 * @ClassName: JZ085
 * @Description: 剑指 Offer II 085. 生成匹配的括号
 */
public class JZ085 {

    public static void main(String[] args) {
        List<String> list = generateParenthesis(3);
        for (String s : list) {
            System.out.println(s);
        }
    }

    /*
            正整数 n 代表生成括号的对数，请设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
     */
    public static List<String> generateParenthesis(int n) {
//        return handle1(n);
        return handle2(n);
    }

    private static List<String> handle2(int n) {
        ArrayList<String> res = new ArrayList<>();
        dfs(0, 0, 0, "", res, n);
        return res;
    }

    /**
     * @param leftNum
     * @param rightNum
     * @param flag     是否合法（小于0非法），初始为0，放入一个左扩号值+1，放入一个右扩号-1
     * @param cur
     * @param res
     * @param n
     */
    private static void dfs(int leftNum, int rightNum, int flag, String cur, ArrayList<String> res, int n) {
        if (leftNum > n || rightNum > n || flag < 0) {
            return;
        }
        if (leftNum == n && rightNum == n && flag == 0) {
            res.add(cur);
            return;
        }
        cur = cur + "(";
        dfs(leftNum + 1, rightNum, flag + 1, cur, res, n);
        cur = cur.substring(0, cur.length() - 1);//n=3，递归到4时，cur=((((有四个左括号，遇到第一个边界条件返回，此时leftNum回到3，cur=((((，需要把多加的最后一个(删去

        cur = cur + ")";
        dfs(leftNum, rightNum + 1, flag - 1, cur, res, n);

    }


    /*
            暴力：
            递归生成所有可能的扩号组合
            过滤出合法的扩号串
     */
    private static List<String> handle1(int n) {
        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> list1 = handle_recursion1(2 * n, "", list);
        list1.removeIf(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                Stack<Character> stack = new Stack<>();
                stack.push(s.charAt(0));
                for (int i = 1; i < s.length(); i++) {
                    if (stack.isEmpty()) {
                        stack.push(s.charAt(i));
                    } else if (stack.peek() == (s.charAt(i) == ')' ? '(' : null)) {
                        stack.pop();
                        continue;
                    } else {
                        stack.push(s.charAt(i));
                    }
                }
                if (!stack.isEmpty()) {
                    return true;
                }
                return false;
            }
        });
        return list1;
    }

    private static ArrayList<String> handle_recursion1(int n, String s, ArrayList<String> list) {
        if (n == 0) {
            list.add(s);
            return list;
        }
        handle_recursion1(n - 1, s + "(", list);
        handle_recursion1(n - 1, s + ")", list);
        return list;
    }

}
