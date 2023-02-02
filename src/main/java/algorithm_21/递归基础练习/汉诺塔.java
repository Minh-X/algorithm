package algorithm_21.递归;

import java.util.Scanner;

/**
 * 汉诺塔
 * @author permission
 * @Date 2021 - 07 - 11 - 21:15
 * @package algorithm.递归基础练习
 * @Description: 将 1-N 从A移动到B，C作为辅助空间
 */
public class 汉诺塔 {
    int step =1;
    /**
     * 汉诺塔问题
     * @param n 层数
     * @param from 起点
     * @param to 终点
     * @param help 辅助空间
     */
    /*
            1. 第1 --- n-1层（最上面是第1层，最下面是第n层） 放到help
            2. 第n层 放到目标位置B
            3. 重复
     */
    public void f1(int n, String from, String to, String help){
        if (n == 1){
            System.out.println(step + ": move " + n + " from " + from + " to " + to);
            step++;
            return;
        }
        f1(n-1, from, help, to);
        System.out.println(step + ": move " + n + " from " + from + " to " + to);
        step++;
        f1(n-1, help, to, from);
    }

    public static void main(String[] args) {
        汉诺塔 obj = new 汉诺塔();
        String from = "A";
        String to = "B";
        String help = "C";
        Scanner scanner = new Scanner(System.in);
        System.out.print("输入汉诺塔的层数：");
        int n = scanner.nextInt();
        obj.f1(n,from,to,help);
    }
}
