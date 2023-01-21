package algorithm7.niucode.hj;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * @Author: permission
 * @Date: 2023/1/21 20:00
 * @Version: 1.0
 * @ClassName: HJ33
 * @Description: HJ33 整数与IP地址间的转换
 */
public class HJ33 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) {
            String str = in.nextLine();
            handle(str);
        }
    }

    private static void handle(String str) {
        if (str.contains(".")) {
            String[] splits = str.split("\\.");
//        String[] splits = str.split(".");
            Integer i1 = Integer.valueOf(splits[0]);
            Integer i2 = Integer.valueOf(splits[1]);
            Integer i3 = Integer.valueOf(splits[2]);
            Integer i4 = Integer.valueOf(splits[3]);
            String s1 = Integer.toUnsignedString(i1, 2);
            if (s1.length() < 8) {
                int len = s1.length();
                StringBuilder sb1 = new StringBuilder(s1);
                sb1.reverse();
                for (int i = len; i < 8; i++) {
                    sb1.append(0);
                }
                s1 = sb1.reverse().toString();
            }
            String s2 = Integer.toBinaryString(i2);
            if (s2.length() < 8) {
                int len = s2.length();
                StringBuilder sb2 = new StringBuilder(s2);
                sb2.reverse();
                for (int i = len; i < 8; i++) {
                    sb2.append(0);
                }
                s2 = sb2.reverse().toString();
            }
            String s3 = Integer.toBinaryString(i3);
            if (s3.length() < 8) {
                int len = s3.length();
                StringBuilder sb3 = new StringBuilder(s3);
                sb3.reverse();
                for (int i = len; i < 8; i++) {
                    sb3.append(0);
                }
                s3 = sb3.reverse().toString();
            }
            String s4 = Integer.toBinaryString(i4);
            if (s4.length() < 8) {
                int len = s4.length();
                StringBuilder sb4 = new StringBuilder(s4);
                sb4.reverse();
                for (int i = len; i < 8; i++) {
                    sb4.append(0);
                }
                s4 = sb4.reverse().toString();
            }
            StringBuilder sb = new StringBuilder();
            sb.append(s1)
                    .append(s2)
                    .append(s3)
                    .append(s4);
            Long res1 = Long.valueOf(sb.toString(), 2);
            System.out.println(res1);
        } else {
//            BigDecimal sbd = new BigDecimal(str);
//            BigDecimal max = new BigDecimal(0x7fffffffffffffffL);
//            if (max.compareTo(sbd) < 0) {
//                return;
//            }
//            if (str.length()>19) {
//                return;
//            }
            String s = Long.toString(Long.parseLong(str), 2);
            if (s.length() < 32) {
                StringBuilder sb = new StringBuilder(s);
                sb.reverse();
                for (int i = s.length(); i < 32; i++) {
                    sb.append(0);
                }
                s = sb.reverse().toString();
            }
            StringBuilder sb = new StringBuilder();
            sb.append(Integer.parseInt(s.substring(0, 8), 2))
                    .append(".")
                    .append(Integer.parseInt(s.substring(8, 16), 2))
                    .append(".")
                    .append(Integer.parseInt(s.substring(16, 24), 2))
                    .append(".")
                    .append(Integer.parseInt(s.substring(24, 32), 2));
            System.out.println(sb);
        }
    }
}
