package algorithm777.h.s100;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: permission
 * @Date: 2023/2/8 23:45
 * @Version: 1.0
 * @ClassName: H11_96_寻找相似单词
 * @Description: 100
 */
public class H11_96_寻找相似单词 {

    public static void main(String[] args) {
/*
4
abc
dsa
bca
fes
abc
期望输出：abc bca

3
fds
fwer
ccc
wac
期望输出：null
*/
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String[] strs = new String[n];
        for (int i = 0; i < n; i++) {
            strs[i] = scanner.nextLine();
        }
        String target = scanner.nextLine();
        handle(strs, target);
    }

    private static void handle(String[] strs, String target) {
        List<String> res = new ArrayList<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            if (target.equals(new String(chars))) {
                res.add(str);
            }
        }
        res = res.stream().sorted().collect(Collectors.toList());
        StringJoiner sj = new StringJoiner(" ");
        for (String r : res) {
            sj.add(r);
        }
        System.out.println(sj.length() == 0 ? "null" : sj);
    }

}
