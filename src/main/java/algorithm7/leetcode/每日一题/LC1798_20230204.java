package algorithm7.leetcode.每日一题;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * @Author: permission
 * @Date: 2023/2/4 0:50
 * @Version: 1.0
 * @ClassName: LC1798
 * @Description: 1798. 你能构造出连续值的最大数目
 */
public class LC1798_20230204 {

    public static void main(String[] args) {
        int[] coins = {1, 1, 1, 4};
        int res = getMaximumConsecutive(coins);
        System.out.println(res);
    }

    public static int getMaximumConsecutive(int[] coins) {
//        return handle1(coins);
        return handle2(coins);
    }

    /*
            贪心，假设能构建 [0...x]，再来一个y可以构建[y....x+y]，要使两区间合并需满足y <= x+1，即可构建[0,x+y]
                                    排序后，取最小的值作为y，如果不满足 y<=x+1，后面的也不会满足
     */
    private static int handle2(int[] coins) {
        int x = 0;//开始可以构建[0...0]，res为1
        Arrays.sort(coins);//排序
        for (int y : coins) {
            if (y > x + 1) {
                break;
            }
            x += y;
        }
        return x + 1;
    }


    /*
        类似01背包，要或者不要（超时）
    */
    private static int handle1(int[] coins) {
        int n = coins.length;
        TreeSet<Integer> can = new TreeSet<>();
        int cur = 0;
        handle_recursion(0, n - 1, coins, can, cur);

        if (can.last() == can.size() - 1) {
            return can.size();
        }

        int res = 0;
        for (int i = 0; i < can.size(); i++) {
            if (can.contains(i)) {
                continue;
            }
            res = i;
            break;
        }
        return res;
    }
    //背包
    private static void handle_recursion(int index, int n, int[] coins, TreeSet<Integer> can, int cur) {
        if (index > n) {
            can.add(cur);
            return;
        }
        //不要index
        handle_recursion(index + 1, n, coins, can, cur);

        //要index
        cur += coins[index];
        handle_recursion(index + 1, n, coins, can, cur);
    }

}
