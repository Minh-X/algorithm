package algorithm7.niucode.hj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: permission
 * @Date: 2023/1/14 3:47
 * @Version: 1.0
 * @ClassName: HJ17
 * @Description: 坐标移动
 */
public class HJ17 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String[] strs = str.split(";");
        System.out.println(f1(strs));
    }

    private static String f1(String[] strs) {
        int x = 0;
        int y = 0;
        for (int i = 0; i < strs.length; i++) {
            if (!strs[i].isEmpty()) {
                String s1 = strs[i].substring(0, 1);
                if ("A".equals(s1) || "D".equals(s1) || "W".equals(s1) || "S".equals(s1)) {
                    String s2 = strs[i].substring(1);
                    try {
                        Integer pos = Integer.parseInt(s2);
                        switch (s1) {
                            case "A":
                                x = x - pos;
                                break;
                            case "D":
                                x = x + pos;
                                break;
                            case "W":
                                y = y + pos;
                                break;
                            case "S":
                                y = y - pos;
                                break;
                        }
                    } catch (Exception e) {
                        continue;
                    }
                }
            }
        }
        return x + "," + y;
    }



}
