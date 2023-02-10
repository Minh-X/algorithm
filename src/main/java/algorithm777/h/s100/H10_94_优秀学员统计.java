package algorithm777.h.s100;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: permission
 * @Date: 2023/2/8 21:53
 * @Version: 1.0
 * @ClassName: H10_94_优秀学员统计
 * @Description: 100
 */
public class H10_94_优秀学员统计 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();//员工数量
        int[] record_count = new int[30];//每天打卡员工数量
        for (int i = 0; i < 30; i++) {
            record_count[i] = scanner.nextInt();
        }
        int[][] record_day_ids = new int[30][];
        for (int i = 0; i < 30; i++) {
            record_day_ids[i] = new int[record_count[i]];
            for (int j = 0; j < record_count[i]; j++) {
                record_day_ids[i][j] = scanner.nextInt();
            }
        }

        handle(n, record_count, record_day_ids);

    }

    private static void handle(int n, int[] record_count, int[][] record_day_ids) {

        HashMap<Integer, List<Integer>> id_clock = new HashMap<>();
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < record_count[i]; j++) {
                int id = record_day_ids[i][j];
                List<Integer> list = id_clock.getOrDefault(id, new ArrayList<>());
                list.add(i);//工号为id的员工第i天打了卡
                id_clock.put(id, list);
            }
        }
        List<Map.Entry<Integer, List<Integer>>> collect = id_clock.entrySet().stream().sorted(new Comparator<Map.Entry<Integer, List<Integer>>>() {
            @Override
            public int compare(Map.Entry<Integer, List<Integer>> o1, Map.Entry<Integer, List<Integer>> o2) {
                if (o1.getValue().size() != o2.getValue().size()) {
                    return o2.getValue().size() - o1.getValue().size();
                } else if (o1.getValue().size() != 0){
                    return o1.getValue().get(0) - o2.getValue().get(0);
                } else {
                    return o1.getKey() - o2.getKey();
                }
            }
        }).collect(Collectors.toList());

        if (collect.size()>5) {
            collect = collect.subList(0,5);
        }
        for (Map.Entry<Integer, List<Integer>> entry : collect) {
            System.out.print(entry.getKey() + " ");
        }

    }


}
/*
11
4 4 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 2 2
0 1 7 10
0 1 6 10
10
10
10
10
10
10
10
10
10
10
10
10
10
10
10
10
10
10
10
10
10
10
10
10
10
10
6 10
7 10
 */