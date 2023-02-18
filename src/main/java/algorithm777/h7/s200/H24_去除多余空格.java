package algorithm777.h7.s200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: permission
 * @Date: 2023/2/17 23:28
 * @Version: 1.0
 * @ClassName: H24
 * @Description:
 */
public class H24_去除多余空格 {

    public static void main(String[] args) {
/*
Life is painting a  picture, not doing 'a  sum'
8 15,20 26,45 47,50 51
期望输出：
Life is painting a picture, not doing 'a  sum'
[8 15][19 25][44 46][48, 49]
 */
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String t = scanner.nextLine();
        String[] tt = t.split(",");
        Integer[][] targets = new Integer[tt.length][2];

        for (int i = 0; i < tt.length; i++) {
            String[] split = tt[i].split(" ");
            targets[i][0] = Integer.valueOf(split[0]);
            targets[i][1] = Integer.valueOf(split[1]);
        }
        handle(s, targets);
    }

    private static void handle(String s, Integer[][] targets) {
        char[] chars = s.toCharArray();
        StringBuilder resStr_sb = new StringBuilder();
        boolean hasFlag = false;
//        ArrayList<Integer> needDel = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '\'') {
                hasFlag = !hasFlag;
            }
            if (chars[i] == ' ' && !hasFlag) {
                if (chars[i - 1] == ' ') {
//                    needDel.add(i);
                    for (Integer[] target : targets) {
                        if (target[0] > i) {
                            target[0]--;
                            target[1]--;
                        }
                    }

                } else {
                    resStr_sb.append(chars[i]);
                }
            } else {
                resStr_sb.append(chars[i]);
            }
        }

        String res = resStr_sb.toString();
        System.out.println(res);
        for (Integer[] target : targets) {
            System.out.print(Arrays.toString(target));
        }
    }

}
