package algorithm7.leetcode.每日一题.YEAR2023.month5;

import org.junit.jupiter.api.Test;

public class DAY20230505_LC2432 {

    public int hardestWorker(int n, int[][] logs) {
//        return handle1(n, logs);
        return handle2(n, logs);
    }

    private int handle2(int n, int[][] logs) {
        int maxCost = logs[0][1];
        int eId = logs[0][0];
        for (int i = 1; i < logs.length; i++) {
            int cost = logs[i][1] - logs[i-1][1];
            int id = logs[i][0];
            if (maxCost < cost || (maxCost == cost && id < eId)) {
                maxCost = cost;
                eId = id;
            }
        }
        return eId;
    }

    private int handle1(int n, int[][] logs) {
        int length = logs.length;
        int temp = logs[0][1];
        int index = 0;
        for (int i = 1; i < length; i++) {
            if (temp < logs[i][1] - logs[i - 1][1]) {
                temp = logs[i][1] - logs[i - 1][1];
                index = i;
            } else if (temp == logs[i][1] - logs[i - 1][1]) {
                if (logs[i][0] < logs[index][0]) {
                    index = i;
                }
            }
        }
        return logs[index][0];
    }

    @Test
    void t1() {

        /*
        70
        [[36,3],[1,5],[12,8],[25,9],[53,11],[29,12],[52,14]]
        期望 12
         */

        int[][] logs = {{0, 3}, {2, 5}, {0, 9}, {1, 15}};
        int res = hardestWorker(10, logs);
        System.out.println("res = " + res);
    }
}
