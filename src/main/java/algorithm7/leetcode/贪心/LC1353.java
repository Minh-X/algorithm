package algorithm7.leetcode.贪心;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author: permission
 * @Date: 2023/1/18 19:52
 * @Version: 1.0
 * @ClassName: LC1353
 * @Description: 1353. 最多可以参加的会议数目
 */
public class LC1353 {

    public static void main(String[] args) {
        int[][] a = {{1,4},{4,4},{2,2},{3,4},{1,1}};
        maxEvents(a);
    }

    public static int maxEvents(int[][] events) {
        if (events == null || events.length == 0) {
            return -1;
        }
        return maxEvents_Handle(events);
    }

    /*
        使用贪心
            策略为 优先会议结束时间早的
    */
    private static int maxEvents_Handle(int[][] events) {
        // 自定义比较器，按照每场会议结束时间进行排序
        Arrays.sort(events, new MyComparator());
        for (int i = 0; i < events.length; i++) {
            System.out.println(events[i][0] + "   " + events[i][1]);
        }
        int res = 0;
        int timeLine = 0;
        for (int i = 0; i < events.length; i++) {
            if (timeLine <= events[i][0]) {//开始时间要比timeLine大（上一场结束时间）
                res++;//场次+1
//                timeLine = events[i][1];//更新结束时间
                timeLine++;//更新结束时间（LC上题的意思大概是一个会议1-7天，第一天来了就）
            }
        }
        return res;
    }

    public static class MyComparator implements Comparator<int[]> {
        @Override
        public int compare(int[] o1, int[] o2) {
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        }
    }


    //能过
    public int maxEvents2(int[][] events) {
        int count = 0;
        int maxDay = 0;
        for (int[] event : events) {
            maxDay = Math.max(maxDay, event[1]);
        }
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        int length = events.length;
        for (int index = 0, day = 0; day <= maxDay; day++) {
            while (!pq.isEmpty() && pq.peek() < day) {
                pq.poll();
            }
            while (index < length && events[index][0] <= day) {
                pq.offer(events[index][1]);
                index++;
            }
            if (!pq.isEmpty()) {
                pq.poll();
                count++;
            }
        }
        return count;
    }
}
