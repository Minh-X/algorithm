package algorithm777.h.s100;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: permission
 * @Date: 2023/2/7 15:30
 * @Version: 1.0
 * @ClassName: H6_86_最接最大输出功率的设备_查找充电设备组合
 * @Description: 100
 */
public class H6_86_最接最大输出功率的设备_查找充电设备组合 {

    public static void main(String[] args) {
/*
4
50 20 20 60
90
期望输出：90

2
50 40
30
期望输出：0
 */

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        Integer[] p = Arrays.stream(in.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        int p_max = in.nextInt();

        t1(p, n, p_max);
        int[][] cache = new int[n + 1][p_max + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < p_max + 1; j++) {
                cache[i][j] = -1;
            }
        }
        int res = handle_recursion(p, 0, 0, p_max, cache);
        System.out.println(res);
    }

    private static int handle_recursion(Integer[] p, int index, int curV, int p_max, int[][] cache) {
        if (curV > p_max) {
            return -1;//要了index-1,超过p_max返回-1，上层判断剪去这个结果
        }
        if (index == p.length) {//越界
            return 0;
        }
        if (cache[index][curV] != -1) {
            return cache[index][curV];
        }
        int p1 = handle_recursion(p, index + 1, curV, p_max, cache);//不要index，去 index + 1 考虑
        int p2 = -1;
        int need = handle_recursion(p, index + 1, curV + p[index], p_max, cache);//要index，去index+1考虑，如果要了之后超过p_max，会返回-1，剪去
        if (need != -1) {//要了index不超过max，加上index的值
            p2 = p[index] + need;
        }
        int res = Math.max(p1, p2);
        cache[index][curV] = res;
        return res;
    }


    public static void t1(Integer[] p, int n, int p_max) {


        //dp[i][j] 表示从下标为[0-i]的物品里任意取，放进容量为j的背包，价值总和最大是多少。
        int[][] dp = new int[n + 1][p_max + 1];

        // 初始化, i为0，存放编号0的物品的时候，各个容量的背包所能存放的最大价值。
        for (int j = p_max; j >= p[0]; j--) {
            dp[0][j] = dp[0][j - p[0]] + p[0];
        }

        for (int i = 1; i < n; i++) {  // 遍历物品
            for (int j = 0; j <= p_max; j++) { // 遍历背包容量
                // 背包容量为j，如果物品i的体积，此时dp[i][j]就是dp[i - 1][j]
                if (j < p[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - p[i]] + p[i]);
                }
            }
        }

        System.out.println(dp[n - 1][p_max]);


    }

}
