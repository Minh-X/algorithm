package algorithm7.niuke.hj;

import java.util.Scanner;
import java.util.TreeMap;

/**
 * @Author: permission
 * @Date: 2023/1/12 2:06
 * @Version: 1.0
 * @ClassName: HJ8
 * @Description: 牛客HJ8
 */
public class HJ8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tableSize = 0;
        if (scanner.hasNextInt()) {
            tableSize = scanner.nextInt();
        }

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < tableSize; i++) {
            int k = scanner.nextInt();
            int v = scanner.nextInt();
            if (map.containsKey(k)) {
                map.put(k, map.get(k) + v);
            } else  {
                map.put(k, v);
            }
        }
        map.entrySet().stream().forEach(entry -> {
            System.out.println(entry.getKey() + " " + entry.getValue());
        });
    }
}
