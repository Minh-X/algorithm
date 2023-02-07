package algorithm777.h.s200;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @Author: permission
 * @Date: 2023/2/7 19:39
 * @Version: 1.0
 * @ClassName: H4_88_简单的解压缩算法
 * @Description: 200
 */
public class H4_88_简单的解压缩算法 {

    public static void main(String[] args) {
/*
{A3B1{C}3}3
输出：AAABCCCAAABCCCAAABCCC
 */
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String res = handle(s);
        System.out.println(res);
        System.out.println(res.equals("AAABCCCAAABCCCAAABCCC"));
    }

    private static String handle(String s) {
        char[] chars = s.toCharArray();
        Deque<Character> deque = new LinkedList<>();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= '0' && chars[i] <= '9') {
                boolean flag = false;
                if (deque.peekLast() == '}') {
                    flag = true;
                    deque.pollLast();
                }
                StringBuilder sb = new StringBuilder();
                while (!deque.isEmpty() && deque.peekLast() != '{') {
                    sb.append(deque.pollLast());
                }
                String s1 = sb.reverse().toString();
                int n = Integer.parseInt(String.valueOf(chars[i]));
                for (int j = 1; j < n; j++) {//
                    sb.append(s1);
                }
                if (flag) {
                    deque.pollLast();
                }
                for (int j = 0; j < sb.length(); j++) {
                    deque.offerLast(sb.charAt(j));
                }
            } else {
                deque.offerLast(chars[i]);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            sb.append(deque.pollFirst());
        }
        return sb.toString();
    }

}
