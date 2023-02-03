package algorithm7.leetcode.哈希;

import java.util.HashMap;

/**
 * @Author: permission
 * @Date: 2023/2/4 1:54
 * @Version: 1.0
 * @ClassName: LC202
 * @Description: 202. 快乐数
 */
public class LC202 {

    public static void main(String[] args) {
        int n = 19;
        boolean res = isHappy(n);
        System.out.println(n + ": " + res);
    }

    public static boolean isHappy(int n) {
        return handle1(n);
    }

    private static boolean handle1(int n) {
        HashMap<Integer, Boolean> map = new HashMap<>();

        while (n != 1) {
            if (map.get(n) != null) {
                return false;
            }
            map.put(n, true);
            String s = String.valueOf(n);
            n = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                int k = Integer.parseInt(String.valueOf(c));
                n += (int) Math.pow(k, 2);
            }
        }
        return true;
    }
}
