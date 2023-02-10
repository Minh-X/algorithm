package algorithm777.h.s100;

import java.util.*;

/**
 * @Author: permission
 * @Date: 2023/2/10 13:33
 * @Version: 1.0
 * @ClassName: H13_98_微服务的集成测试
 * @Description: 100
 */
public class H13_98_微服务的集成测试 {

    public static void main(String[] args) {
/*
3
5 0 0
1 5 0
0 1 5
3
期望：15

3
5 0 0
1 5 0
0 1 5
1
期望：5

3
5 0 0
1 5 0
0 1 5
2
期望：10

3
5 0 0
1 10 1
1 0 11
2
期望：26
 */
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();//服务数量
        int[][] relations = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                relations[i][j] = scanner.nextInt();
            }
        }
        int k = scanner.nextInt();
        int res = handle(relations,k);
        System.out.println();
        System.out.println("min：" + res);
    }

    private static int handle(int[][] relations, int k) {
        int n = relations.length;
        Map<Integer, List<Integer>> out_map = new HashMap<>();//v为出度列表
        Map<Integer, Integer> in_map = new HashMap<>();//k-v，k为服务id，v为入度数量
        Map<Integer, Integer> startTime_map = new HashMap<>();//v为某个服务启动时间
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    startTime_map.put(i, relations[i][j]);
                } else {
                    if (relations[i][j] == 1) {
                        List<Integer> list = out_map.getOrDefault(j, new ArrayList<>());
                        list.add(i);
                        out_map.put(j, list);
                        in_map.put(i, in_map.getOrDefault(i, 0) + 1);
                    }
                }
            }
        }
        Deque<Integer> deque = new LinkedList<>();
        int minCost = 0;
        for (int i = 0; i < n; i++) {
            Integer i_in = in_map.getOrDefault(i, 0);
            if (i_in == 0) {
                deque.offerLast(i);
            }
        }
        List<Deque> list = new ArrayList<>();
        list.add(deque);
        boolean flag = false;
        //一轮一个que，就能轻松统计出每轮的时间
        for (int i = 0; i < n; i++) {
            int min = 0;
            Deque<Integer> nextDeque = new LinkedList<>();
            deque = list.get(i);
            if (deque != null && deque.size() != 0) {
                while (!deque.isEmpty()) {
                    Integer taskId = deque.pollFirst();
                    min = Math.max(startTime_map.get(taskId), min);
                    if (taskId == k -1) {
                        flag = true;
                    }
                    System.out.print(taskId + " ");
                    List<Integer> out = out_map.getOrDefault(taskId, new ArrayList<>());
                    for (Integer outId : out) {
                        int curIn = in_map.get(outId) - 1;
                        if (curIn == 0) {
                            nextDeque.offerLast(outId);
                        } else {
                            in_map.put(outId, curIn);
                        }
                    }
                }
                list.add(nextDeque);
            } else {
                break;
            }
            minCost += min;
            if (flag) {
                return minCost;
            }
        }
        return minCost;
    }

}
