package algorithm7.leetcode.贪心;

/**
 * @Author: permission
 * @Date: 2023/2/4 13:56
 * @Version: 1.0
 * @ClassName: LC134
 * @Description: 134. 加油站
 */
public class LC134 {

    public static void main(String[] args) {
        int[] gas = {5,1,2,3,4};
        int[] cost = {4,4,1,5,1};
        int res = canCompleteCircuit(gas, cost);
        System.out.println(res);
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
//        return handle_greedy1(gas, cost);
        return handle_greedy2(gas, cost);
    }

    private static int handle_greedy2(int[] gas, int[] cost) {
        int n = gas.length;
        int totalGas = 0;
        int totalCost = 0;
        for (int i = 0; i < n; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
        }
        if (totalGas < totalCost) {//如果总油量大于总消耗，肯定有解，反之无解
            return -1;
        }

        int curGas = 0;
        int start=0;
        int i = 0;
        //上面已经确定肯定有解，所以只用遍历一遍即可找到解（从0...n-1肯定能找到解，只要一个点都能持续往下就是解）
        while (i < n) {
            curGas = curGas + gas[i];
            if (curGas <  cost[i]) {//无法到下一站
                curGas = 0;
                start = i + 1;//尝试把下一站作为起点
            } else {//能到达下一站
                curGas = curGas - cost[i];
            }
            i++;//下一站
        }
        return start;
    }

    private static int handle_greedy1(int[] gas, int[] cost) {
////        int[] gas =  {1, 2, 3, 4, 5};
////        int[] cost = {3, 4, 5, 1, 2};
        int n = gas.length;
        int i = 0;
        // 从头到尾遍历每个加油站，并且检查以该加油站为起点，能否行驶一周
        while (i < n) {
            int sumOfGas = 0; // 总共加的油
            int SumOfCost = 0; // 总共消费的油
            int count = 0;     // 记录能走过几个站点
            while (count < n) {  // 退出循环的条件是走过所有的站点
                int j  = (i + count) % n; //当前位置 加油站是环形的
                sumOfGas += gas[j];
                SumOfCost += cost[j];
                if (SumOfCost > sumOfGas) { // 如果这个站点发现油不够了
                    break;
                }
                count++; // 这个站点满足情况
            }

            if (count == n) {  // 如果能环绕一圈
                return i;
            } else { // 不行的话 从下一个站点开始 检查
                i = i + count + 1;
            }
        }
        // 所有加油站作为起点都不满足
        return -1;
    }
}
