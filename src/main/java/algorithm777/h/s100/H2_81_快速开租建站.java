package algorithm777.h.s100;

import java.util.*;

/**
 * @Author: permission
 * @Date: 2023/2/6 2:52
 * @Version: 1.0
 * @ClassName: H2
 * @Description: 100
 * LC2050
 */
public class H2_81_快速开租建站 {

    public static void main(String[] args) {

        /*
5
3
0 3
0 4
1 3
         */
        // 处理输入
        Scanner in = new Scanner(System.in);
        int taskNum = in.nextInt();
        int relationsNum = in.nextInt();

        int[][] relation_ids = new int[relationsNum][2];
        for (int i = 0; i < relationsNum; i++) {
            relation_ids[i][0] = in.nextInt();
            relation_ids[i][1] = in.nextInt();
        }
        t1(taskNum, relation_ids);
        handle(taskNum, relation_ids);
    }

    private static void handle(int taskNum, int[][] relation_ids) {
        int[] in = new int[taskNum];//入度数组，入读可以只用记录个数
        List<List<Integer>> out = new ArrayList<>(taskNum);//出度列表，key为任务id，值为依赖它的任务id列表
        for (int i = 0; i < taskNum; i++) {
            out.add(new ArrayList<>());
        }

        for (int i = 0; i < relation_ids.length; i++) {
            in[relation_ids[i][1]]++;//初始化入度数组（个数）
            out.get(relation_ids[i][0]).add(relation_ids[i][1]);//出度
        }

        // bfs
        Queue<int[]> queue = new LinkedList<>();
        int res = 1;
        for (int i = 0; i < taskNum; i++) {
            if (in[i] == 0) {
                queue.add(new int[]{i, res});//入度为0的入队
            }
        }
        while (!queue.isEmpty()) {
            int[] taskInfo = queue.poll();
            int task = taskInfo[0];
            int curRes = taskInfo[1];
            List<Integer> taskOut = out.get(task);
            for (Integer next : taskOut) {//遍历当前任务的下一个任务
                //如果next入度-1后入读为0，则将next加入queue
                in[next]--;
                if (in[next] == 0) {
                    res = curRes + 1;//防止重复加，同一层的res相同（如测试用例中，0、1、2的res为1，取出0的next(3、4)加入，3、4的res为2，再取0的出度加入，此时0的res应该还是1而不是2）
                    queue.add(new int[]{next, res});
                }
            }
        }
        System.out.println(res);
    }


    public static void t1(int taskNum, int[][] relation_ids) {
        // 每个任务的前置依赖任务个数，也就是拓扑排序中的入度
        int[] upstream = new int[taskNum];
        // 每个任务的下游任务， 也就是拓扑排序中的出度
        List<List<Integer>> downstream = new ArrayList<List<Integer>>(taskNum);
        for (int i = 0; i < taskNum; i++) {
            downstream.add(new ArrayList<>());
        }

        //初始化入度、出度
        for (int[] relation_id : relation_ids) {
            downstream.get(relation_id[0]).add(relation_id[1]);
            upstream[relation_id[1]] += 1;
        }

        //队列中保存当前入度为0 的任务id
        LinkedList<Integer[]> queue = new LinkedList<>();
        int result = 1;

        for (int i = 0; i < taskNum; i++) {
            //将所有入度为零的任务入队, 默认耗时为1
            if (upstream[i] == 0) {
                queue.add(new Integer[]{i, result});
            }
        }

        while (queue.size() > 0) {
            Integer[] current_task = queue.removeFirst();
            int task = current_task[0];
            int time = current_task[1];

            for (Integer downstream_task : downstream.get(task)) {
                // 当前任务的入度减小到0时，放入queue中
                if (--upstream[downstream_task] == 0) {
                    result = time + 1;
                    queue.add(new Integer[]{downstream_task, result});
                }
            }

        }

        System.out.println(result);

    }


}
