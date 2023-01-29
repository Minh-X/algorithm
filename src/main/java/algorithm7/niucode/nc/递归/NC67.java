package algorithm7.niucode.nc.递归;

import java.util.ArrayList;

/**
 * @Author: permission
 * @Date: 2023/1/29 14:35
 * @Version: 1.0
 * @ClassName: NC67
 * @Description: NC67 汉诺塔问题
 *
 *
 *
 * 我们有由底至上为从大到小放置的 n 个圆盘，和三个柱子（分别为左/中/右即left/mid/right），
 * 开始时所有圆盘都放在左边的柱子上，按照汉诺塔游戏的要求我们要把所有的圆盘都移到右边的柱子上，
 * 要求一次只能移动一个圆盘，而且大的圆盘不可以放到小的上面。
 *
 * 请实现一个函数打印最优移动轨迹。
 */
public class NC67 {

    public static void main(String[] args) {
        getSolution(3);
        for (String re : res) {
            System.out.println(re);
        }
    }

    static ArrayList<String> res = new ArrayList<>();

    public static ArrayList<String> getSolution(int n) {
        // write code here
        handle(n, "left", "right", "mid");
        return res;
    }

    /*
        1. 第1 --- n-1层（最上面是第1层，最下面是第n层） 放到mid
        2. 第n层 放到目标位置right
        3. 重复
    */
    private static void handle(int n, String from, String to, String help) {
        if (n == 1) {
            res.add("move from " + from + " to " + to);
            return;
        }
        handle(n - 1, from, help, to);
        res.add("move from " + from + " to " + to);
        handle(n - 1, help, to, from);
    }


}
