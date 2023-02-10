package algorithm7.leetcode.每日一题;

import java.util.Arrays;

/**
 * @Author: permission
 * @Date: 2023/2/11 1:27
 * @Version: 1.0
 * @ClassName: LC2335_20230211
 * @Description: 装满杯子需要的最短总时长
 */
public class LC2335_20230211 {

    public static void main(String[] args) {
        int[] amount = {5, 6, 7};
        int res = fillCups(amount);
        System.out.println(res);
    }

    public static int fillCups(int[] amount) {
        return handle(amount);
    }

    /*
        贪心，每次选最多的两个（保证最多的一次两杯次数）
     */
    private static int handle(int[] amount) {
        Arrays.sort(amount);
        //最小的两个和小于第三个，1、最大的需求超过其他两种需求之和，则次数就是最大需求数
        if (amount[2] > amount[0] + amount[1]) {
            return amount[2];
        }
        //和为偶数，能凑出每次两杯；奇数的话凑出两倍后单出1杯   2、最大的需求不超过其他两种需求之和，则次数就是需求总和求半（和为偶数）
//        return (amount[0] + amount[1] + amount[2]) % 2 == 0 ? (amount[0] + amount[1] + amount[2]) / 2 : (amount[0] + amount[1] + amount[2]) / 2 + 1;
        return (amount[0] + amount[1] + amount[2] + 1) / 2;//上面可以简化成这样
    }

}
