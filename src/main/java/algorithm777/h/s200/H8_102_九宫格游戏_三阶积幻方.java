package algorithm777.h.s200;

import java.util.*;

/**
 * @Author: permission
 * @Date: 2023/2/10 19:39
 * @Version: 1.0
 * @ClassName: H8_102_九宫格游戏_三阶积幻方
 * @Description: 200
 */
public class H8_102_九宫格游戏_三阶积幻方 {

    public static void main(String[] args) {
/*
75 36 10 4 30 225 90 25 12
期望：
10 36 75 225 30 4 12 25 90
10 225 12 36 30 25 75 4 90
12 25 90 225 30 4 10 36 75
12 225 10 25 30 36 90 4 75
75 4 90 36 30 25 10 225 12
75 36 10 4 30 225 90 25 12
90 4 75 25 30 36 12 225 10
90 25 12 4 30 225 75 36 10

1 2 4 5 10 20 25 50 100
期望：
2 25 20 100 10 1 5 4 50
2 100 5 25 10 4 20 1 50
5 4 50 100 10 1 2 25 20
5 100 2 4 10 25 50 1 20
20 1 50 25 10 4 2 100 5
20 25 2 1 10 100 50 4 5
50 1 20 4 10 25 5 100 2
50 4 5 1 10 100 20 25 2

 */
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            list.add(scanner.nextInt());
        }

        List<List<Integer>> res = handle(list);
        res.sort((x, y) -> {
            for (int i = 0; i < 9; i++) {
                if (x.get(i) != y.get(i)) {
                    return x.get(i) - y.get(i);
                }
            }
            return 0;
        });

        for (List<Integer> r : res) {
            for (Integer integer : r) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }

    }

    private static List<List<Integer>> handle(ArrayList<Integer> list) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(list, 0, list.size(), res);
        return res;
    }

    private static void dfs(ArrayList<Integer> list, int index, int size, List<List<Integer>> res) {
        if (index == size - 1) {
            if (isValid(list)) {
//                ArrayList<Integer> cur = new ArrayList<>();
                res.add((List<Integer>) list.clone());
            }
            return;
        }
        for (int i = index; i < size; i++) {
            Collections.swap(list, i, index);
            dfs(list, index + 1, size, res);
            Collections.swap(list, index, i);
        }

    }

    private static boolean isValid(ArrayList<Integer> list) {
        Integer n0 = list.get(0);
        Integer n1 = list.get(1);
        Integer n2 = list.get(2);
        Integer n3 = list.get(3);
        Integer n4 = list.get(4);
        Integer n5 = list.get(5);
        Integer n6 = list.get(6);
        Integer n7 = list.get(7);
        Integer n8 = list.get(8);
        boolean isValid = false;
        //1 每行乘积相等
        int r1 = n0 * n1 * n2;
        int r2 = n3 * n4 * n5;
        int r3 = n6 * n7 * n8;
        //2 每列乘积相等
        int c1 = n0 * n3 * n6;
        int c2 = n1 * n4 * n7;
        int c3 = n2 * n5 * n8;
        //3 对角线乘积相等
        int p1 = n2 * n4 * n6;
        int p2 = n0 * n4 * n8;
        if (r1 == r2 && r1 == r3 && r2 == r3 &&
                c1 == c2 && c1 == c3 && c2 == c3 &&
                p1 == p2) {
            isValid = true;
        }
        return isValid;
    }

}
