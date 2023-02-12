package algorithm777.h.s100;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @Author: permission
 * @Date: 2023/2/11 0:11
 * @Version: 1.0
 * @ClassName: H20_106_工单调度策略
 * @Description: 100
 */
public class H20_106_工单调度策略 {

    public static void main(String[] args) {
/*
7
1 6
1 7
3 2
3 1
2 4
2 5
6 1
期望输出：15

3
1 1
2 10
2 20
期望：30

 */
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] infos = new int[n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                infos[i][j] = scanner.nextInt();
            }
        }

        handle(infos, n);

    }

    /*
            优先队列+贪心，类似LC630
            先按照时间紧急度排序，最紧急的优先
            定义一个小根堆（能获取的积分小的在堆顶），按紧急度遍历数组入队，超时则舍去，未超时入队，时间一样和堆顶比较做取舍
     */
    private static void handle(int[][] infos, int n) {
        Arrays.sort(infos, (Comparator.comparingInt(o -> o[0])));//截至时间升序排序

        //小根堆（积分小的在上）   工单按照时间排列，每次取最紧急的，然后加入queue
        //                          此时：  1 时间过了，放弃该任务
        //                                 2 时间小于当前时间，直接加入
        //                                 3 时间等于当前时间，和堆顶比较，取积分大的

        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a));
        int curTime = 0;
        queue.offer(infos[0][1]);//先将第一个任务加入（第一个任务完成的积分）
        curTime++;//每个任务都是1h
        for (int i = 1; i < n; i++) {
            if (curTime == infos[i][0]) {//等于是因为infos按时间排序，可能同一时间有多个，上次加的前面的积分更小，这一次如果时间一样，积分更多，挤掉上一次决定要完成的任务
                if (queue.peek() < infos[i][1]) {
                    queue.poll();
                    queue.offer(infos[i][1]);
                }
            } else if (curTime < infos[i][0]) {//当前时间小于决定做不做的任务的时间，直接加入
                queue.offer(infos[i][1]);
                curTime++;//当前时间+1
            } else {//大于，时间已经过了（如果该任务积分比队列中所有加起来都大，清空队列，加入）

            }
        }
        //遍历完，队列中的积分和即为最大
        int res = 0;
        for (Integer integer : queue) {
            res += integer;
        }
        System.out.println(res);
    }

}
