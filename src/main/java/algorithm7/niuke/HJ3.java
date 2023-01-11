package algorithm7.niuke;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * @Author: permission
 * @Date: 2023/1/11 20:14
 * @Version: 1.0
 * @ClassName: HJ3
 * @Description: 明明的随机数
 */
public class HJ3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeSet<Integer> set = new TreeSet<>();
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            Integer anInt = scanner.nextInt();
            set.add(anInt);
        }
        set.stream().forEach(System.out::println);
    }
}
