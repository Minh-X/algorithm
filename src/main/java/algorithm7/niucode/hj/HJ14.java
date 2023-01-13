package algorithm7.niucode.hj;

import java.util.*;

/**
 * @Author: permission
 * @Date: 2023/1/12 14:53
 * @Version: 1.0
 * @ClassName: HJ14
 * @Description: 字符串排序
 */
public class HJ14 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            String str = scanner.next();
            list.add(str);
        }
        list.stream().sorted().forEach(System.out::println);
    }

}