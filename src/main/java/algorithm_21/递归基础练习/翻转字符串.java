package algorithm_21.递归基础练习;

import java.util.Scanner;

/**
 * 翻转字符串
 * @author permission
 * @Date 2021 - 06 - 18 - 23:37
 * @package algorithm.递归基础练习
 * @Description:
 */
public class 翻转字符串 {

    public String reverse(String str, int end){
        if (end == 0){
            return "" + str.charAt(0);
        }
        return str.charAt(end) + reverse(str, end-1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        str = new 翻转字符串().reverse(str, str.length()-1);
        System.out.println(str);
    }
}
