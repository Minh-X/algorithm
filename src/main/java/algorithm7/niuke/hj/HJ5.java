package algorithm7.niuke.hj;

import java.util.Scanner;

/**
 * @Author: permission
 * @Date: 2023/1/11 21:48
 * @Version: 1.0
 * @ClassName: HJ5
 * @Description: 进制转换 十六进制转十进制
 */
public class HJ5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextLine()) {
            String str = scanner.nextLine();
            trans2(str);
        }
        scanner.close();
    }

    private static void trans2(String str) {
        str = str.replaceAll("0x", "");
        int res = Integer.parseInt(str, 16);
        System.out.println(res);
    }


    private static void trans(String str) {
        str = str.substring(2);
        int res = 0;
        for (int i = str.length()-1; i >= 0; i--) {
            char c = str.charAt(str.length()-1 - i);
            switch (c) {
                case '0':
                    break;
                case '1':
                    res += 1 * Math.pow(16, i);
                    break;
                case '2':
                    res += 2 * Math.pow(16, i);
                    break;
                case '3':
                    res += 3 * Math.pow(16, i);
                    break;
                case '4':
                    res += 4 * Math.pow(16, i);
                    break;
                case '5':
                    res += 5 * Math.pow(16, i);
                    break;
                case '6':
                    res += 6 * Math.pow(16, i);
                    break;
                case '7':
                    res += 7 * Math.pow(16, i);
                    break;
                case '8':
                    res += 8 * Math.pow(16, i);
                    break;
                case '9':
                    res += 9 * Math.pow(16, i);
                    break;
                case 'a':
                case 'A':
                    res += 10 * Math.pow(16, i);
                    break;
                case 'b':
                case 'B':
                    res += 11 * Math.pow(16, i);
                    break;
                case 'c':
                case 'C':
                    res += 12 * Math.pow(16, i);
                    break;
                case 'd':
                case 'D':
                    res += 13 * Math.pow(16, i);
                    break;
                case 'e':
                case 'E':
                    res += 14 * Math.pow(16, i);
                    break;
                case 'f':
                case 'F':
                    res += 15 * Math.pow(16, i);
                    break;
                default:
                    break;
            }
        }
        System.out.println(res);
    }

}
