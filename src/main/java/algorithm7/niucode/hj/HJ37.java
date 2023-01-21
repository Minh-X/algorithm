package algorithm7.niucode.hj;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author: permission
 * @Date: 2023/1/22 1:43
 * @Version: 1.0
 * @ClassName: HJ37
 * @Description: HJ37 统计每个月兔子的总数
 */
public class HJ37 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            cal(n);
        }
    }

    private static void cal(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        map.put(2, 0);
        map.put(3, 0);
        int temp;
        for (int i = 1; i < n; i++) {
            map.put(3, map.get(2) + map.get(3));
            map.put(2, 0);
            temp = map.get(3);
            map.put(2, map.get(1) + map.get(2));
            map.put(1, 0);
            map.put(1, map.get(1) + temp);
        }
        System.out.println(map.get(1) + map.get(2) + map.get(3));
    }

}
