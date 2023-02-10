package algorithm777.h.s100;

import java.util.*;

/**
 * @Author: permission
 * @Date: 2023/2/8 21:10
 * @Version: 1.0
 * @ClassName: H9_93_快递投放问题
 * @Description: 100
 */
public class H9_93_快递投放问题 {

    public static void main(String[] args) {
/*
4 2
package1 A C
package2 A C
package3 B C
package4 A C
A B package1
A C package2
输出：package2
*/
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();//m个包裹
        int n = scanner.nextInt();//n条路
        String[][] pack = new String[m][3];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 3; j++) {
                pack[i][j] = scanner.next();
            }
        }
        String[][] cant = new String[n][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                cant[i][j] = scanner.next();
            }
        }
        handle(pack, cant);
    }

    private static void handle(String[][] pack, String[][] cant) {
        HashMap<String, Set<String>> need = new HashMap<>();//key为路，如AC，表示A到C，value为此路上要运输的包裹
        Set<String> need_pack = new HashSet<>();

        Set<String> res_cantPack = new TreeSet<>();//不能送达的包裹
        for (String[] needInfo : pack) {
            String edge = needInfo[1] + needInfo[2];
            need_pack.add(needInfo[0]);
            need.put(edge, need_pack);
        }
        for (String[] cantInfo : cant) {
            String edge = cantInfo[0] + cantInfo[1];
            Set<String> set = need.get(edge);
            if (set != null && set.contains(cantInfo[2])) {
                res_cantPack.add(cantInfo[2]);
            }
        }
        if (res_cantPack.size() == 0) {
            System.out.println("none");
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (String cantpack : res_cantPack) {
            sb.append(cantpack + " ");
        }
        String res = sb.toString().trim();
        System.out.println(res);
    }

}
