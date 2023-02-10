package algorithm777.h.s100;

import java.util.*;

/**
 * @Author: permission
 * @Date: 2023/2/10 21:38
 * @Version: 1.0
 * @ClassName: H17_103_模拟商场优惠打折II
 * @Description: 100
 */
public class H17_103_模拟商场优惠打折II {

    public static void main(String[] args) {

/*
3 2 5
3
100
200
400
期望输出：
65 6
155 7
338 4
 */
        Scanner scanner = new Scanner(System.in);
        int[] coupon = new int[3];//3种优惠券数量 coupon[0]满减100-10  coupon[1]打折92折（只能用一张） coupon[2]无门槛5元
        for (int i = 0; i < 3; i++) {
            coupon[i] = scanner.nextInt();
        }
        int n;//人数
        n = scanner.nextInt();
        int[] costs = new int[n];//第i人消费多少元
        for (int i = 0; i < n; i++) {
            costs[i] = scanner.nextInt();
        }
        List<int[]> res = handle(coupon, n, costs);
        for (int[] r : res) {
            StringJoiner sj = new StringJoiner(" ");
            for (int i : r) {
                sj.add(i + "");
            }
            System.out.println(sj);
        }
    }

    /*
            三种打折方式，6种组合
            1 先满减，再打折
            2 先满减，再无门槛
            3 先打折，再满减
            4 先打折，再无门槛

            5 先无门槛，再满减
            6 先无门槛，再打折
            其中第5、6种方案先无门槛肯定无法获取最优价格（无门槛可以最后用，先用可能让前面有门槛的无法满足），不用考虑
     */
    private static List<int[]> handle(int[] coupon, int n, int[] costs) {
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ArrayList<int[]> temp = new ArrayList<>();
            int cost = costs[i];//第i个人消费额
            //1 第一种方案需支付多少： 先满减，再打折
            int[] payInfo1 = p1(coupon, cost);
            temp.add(payInfo1);
            //2 第二种方案需支付多少： 先满减，再无门槛
            int[] payInfo2 = p2(coupon, cost);
            temp.add(payInfo2);
            //3 第三种方案需支付多少： 先打折，再满减
            int[] payInfo3 = p3(coupon, cost);
            temp.add(payInfo3);
            //4 第四种方案需支付多少： 先打折，再无门槛
            int[] payInfo4 = p4(coupon, cost);
            temp.add(payInfo4);
            temp.sort(Comparator.comparingInt(o -> o[0]));
            int[] minCostInfo = temp.get(0);
            res.add(minCostInfo);
        }
        return res;
    }

    //4 第四种方案需支付多少： 先打折，再无门槛
    private static int[] p4(int[] coupon, int cost) {
        int ans = cost;
        if (coupon[1] > 0) {//有打折券
            ans = (int) Math.floor(ans * 0.92);
        }
        int num2 = coupon[2];
        ans = ans - num2 * 5;
        return new int[]{ans, 1 + num2};
    }

    //3 第三种方案需支付多少： 先打折，再满减
    private static int[] p3(int[] coupon, int cost) {
        int ans = cost;
        if (coupon[1] > 0) {//有打折券
            ans = (int) Math.floor(ans * 0.92);
        }
        int num2 = Math.min(ans / 100, coupon[0]);//最多能用多少张满减券
        ans = ans - num2 * 10;
        return new int[]{ans, 1 + num2};
    }

    //2 第二种方案需支付多少： 先满减，再无门槛
    private static int[] p2(int[] coupon, int cost) {
        int num1 = Math.min(cost / 100, coupon[0]);//最多能用多少张满减券
        int ans = cost - num1 * 10;
        int num2 = coupon[2];
        ans = ans - num2 * 5;
        return new int[]{ans, num1 + num2};
    }

    //1 第一种方案需支付多少： 先满减，再打折
    private static int[] p1(int[] coupon, int cost) {
        int num1 = Math.min(cost / 100, coupon[0]);//最多能用多少张满减券
        int ans = cost - num1 * 10;
        if (coupon[1] > 0) {//有打折券
            ans = (int) Math.floor(ans * 0.92);
        }
        return new int[]{ans, num1 + 1};//0:支付额、1:使用优惠券数量
    }

}
