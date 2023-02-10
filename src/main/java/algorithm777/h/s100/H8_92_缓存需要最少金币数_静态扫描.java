package algorithm777.h.s100;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @Author: permission
 * @Date: 2023/2/8 20:49
 * @Version: 1.0
 * @ClassName: H8_92_缓存需要最少金币数_静态扫描
 * @Description: 100
 */
public class H8_92_缓存需要最少金币数_静态扫描 {

    public static void main(String[] args) {
/*
5
1 2 2 1 2 3 4
1 1 1 1 1 1 1
期望：7

5
2 2 2 2 2 5 2 2 2
3 3 3 3 3 1 3 3 3
期望：9
*/
        Scanner scanner = new Scanner(System.in);
        int cache_cost = Integer.parseInt(scanner.nextLine());
        Integer[] f = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        Integer[] s = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        handle(cache_cost, f,s);
    }

    private static void handle(int cache_cost, Integer[] f, Integer[] s) {
        int min_cost = 0;
        HashMap<Integer, Integer> fid_count_map = new HashMap<>();
        HashMap<Integer, Integer> fid_size_map = new HashMap<>();
        for (int i = 0; i < f.length; i++) {
            fid_count_map.put(f[i], fid_count_map.getOrDefault(f[i], 0) + 1);
            fid_size_map.putIfAbsent(f[i], s[i]);
        }
        for (Integer fid : fid_count_map.keySet()) {
            int cost_no = fid_count_map.get(fid) * fid_size_map.get(fid);//不缓存
            int cost_yes = fid_size_map.get(fid) + cache_cost;//缓存（第一次花费size，再加上缓存花费）
            min_cost += Math.min(cost_no, cost_yes);
        }
        System.out.println(min_cost);
    }
}
