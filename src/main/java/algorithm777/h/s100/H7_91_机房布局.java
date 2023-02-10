package algorithm777.h.s100;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @Author: permission
 * @Date: 2023/2/8 15:43
 * @Version: 1.0
 * @ClassName: H7_91_机房布局
 * @Description: 100
 */
public class H7_91_机房布局 {

    public static void main(String[] args) {

/*
MIIM
期望输出：2

MIIIMMIMMIIIMIMIIIMI
期望输出：6
 */
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int res = handle(s);
        int res2 = handle2(s);
        System.out.println(res);
        System.out.println(res2);
    }

    /*
            贪心，优先放M后面，后面放不了放前面
     */
    private static int handle2(String s) {
        if (s == null || s.length() < 2) {
            return -1;
        }
        if (s.startsWith("MM") || s.endsWith("MM") || s.contains("MMM")) {//三种无解的情况
            return -1;
        }
        char[] chars = s.toCharArray();
        int res = 0;
        //              遍历，找到第一个M，
        //              1.如果是最后一个，灯放i-1，结束
        //              2.如果后面是I，直接放灯，把i+1，和i-1点亮（设为T，不再考虑）,跳到i+2
        //              3.如果后面是M，i-1放灯，点亮i；i+2放灯，点亮i+1和i+3，直接跳到i+4
        //
        int i = 0;
        while (i < chars.length) {
            if (chars[i] == 'M') {//找到M
                if (i + 1 >= chars.length) {//是最后一个位置
                    res++;
//                    chars[i - 2] = 'T';
//                    chars[i] = 'T';
                    break;
                } else if (chars[i + 1] == 'I') {//后面是I
                    res++;
//                    chars[i] = 'T';
//                    if (i + 2 < chars.length) {
//                        chars[i + 2] = 'T';
//                    }
                    i += 3;
                } else if (chars[i + 1] == 'M') {//后面是M
                    //i-1放灯，点亮
                    res++;
//                    if (i - 2 >= 0) {
//                        chars[i - 2] = 'T';
//                    }
//                    chars[i] = 'T';
                    //i+2放灯，点亮
                    res++;
//                    chars[i + 1] = 'T';
//                    if (i + 3 < chars.length) {
//                        chars[i + 3] = 'T';
//                    }
                    i += 4;
                }
            } else {
                i++;
            }
        }
        return res;
    }

    private static int handle(String s) {
        if (s.startsWith("MM") || s.endsWith("MM") || s.contains("MMM")) {//三种无解的情况
            return -1;
        }
        char[] chars = s.toCharArray();

        Deque<Integer> deque = new LinkedList<>();
        boolean flag = false;
        for (int i = 0; i < chars.length; i++) {

            if (chars[i] == 'M') {//机柜

                int left = i - 1 < 0 ? 0 : i - 1;
                int right = i + 1 > chars.length - 1 ? chars.length - 1 : i + 1;

                if (deque.size() > 0 && !flag) {
                    //满足MIM
                    if (deque.getLast() == left) {
                        deque.removeLast();
                        flag = true;
                    }
                } else {
                    flag = false;
                }
                deque.addLast(right);
            }
        }
        return deque.size();
    }

}
