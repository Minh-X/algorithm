package algorithm7.niuke.hj;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @Author: permission
 * @Date: 2023/1/12 2:29
 * @Version: 1.0
 * @ClassName: HJ9
 * @Description:
 */
public class HJ9 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = 0;
        if (scanner.hasNextInt()) {
            num = scanner.nextInt();
        }
        String strNum = String.valueOf(num);
        StringBuilder res = new StringBuilder();
        HashSet<Character> set = new HashSet<>();
        for (int i = strNum.length()-1; i >= 0; i--) {
            if (!set.contains(strNum.charAt(i))) {
                set.add(strNum.charAt(i));
                res.append(strNum.charAt(i));
            }
        }
        System.out.println(res);
    }

}
