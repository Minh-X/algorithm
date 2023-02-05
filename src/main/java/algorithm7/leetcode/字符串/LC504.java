package algorithm7.leetcode.字符串;

/**
 * @Author: permission
 * @Date: 2023/2/5 16:31
 * @Version: 1.0
 * @ClassName: LC504
 * @Description: 504. 七进制数
 */
public class LC504 {

    public static void main(String[] args) {

        int num = -7;
        String res = convertToBase7(num);
        System.out.println(res);

    }

    public static String convertToBase7(int num) {
        return handle1(num);
    }

    private static String handle1(int num) {
        String res = "";
        res = Integer.toString(num, 7);
        return res;
    }

}
