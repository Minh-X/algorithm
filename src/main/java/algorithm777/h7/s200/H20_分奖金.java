package algorithm777.h7.s200;

import java.util.*;

/**
 * @Author: permission
 * @Date: 2023/2/14 23:03
 * @Version: 1.0
 * @ClassName: H20_分奖金
 * @Description: 200
 */
public class H20_分奖金 {

    public static void main(String[] args) {
/*
3
2 10 3
期望输出：8 10 3

 */
        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
        int n = 10000000;
        int[] infos = new int[n];
        for (int i = 0; i < n; i++) {
//            infos[i] = scanner.nextInt();
            infos[i] = new Random().nextInt(100000);
        }

        long start = System.currentTimeMillis();
        List<Integer> res = handle1(infos, n);
        long end = System.currentTimeMillis();

        long start2 = System.currentTimeMillis();
        List<Integer> res2 = handle2(infos, n);
        long end2 = System.currentTimeMillis();

        long start3 = System.currentTimeMillis();
        List<Integer> res3 = handle3(infos, n);
        long end3 = System.currentTimeMillis();

//        for (Integer r : res) {
//            System.out.print(r + " ");
//        }
//        System.out.println();
//        for (Integer r : res2) {
//            System.out.print(r + " ");
//        }
        System.out.println(res.get(10000));
        System.out.println(res2.get(10000));
        System.out.println(res3.get(10000));
        System.out.println();
        System.out.println("暴力耗时 O(n^2)： " + (end - start) + " ms");
        System.out.println("队列耗时 O(n)： " + (end2 - start2) + " ms");
        System.out.println("栈耗时 O(n)： " + (end3 - start3) + " ms");

    }

    /*
            利用双端队列，时间复杂度 O(n)
     */
    private static List<Integer> handle2(int[] infos, int n) {
        int[] nextBigIndex = new int[n];
        Deque<Integer> queue = new LinkedList<>();
        queue.add(0);
        int i = 1;
        while (i < n) {
            while (!queue.isEmpty() && infos[queue.peekLast()] < infos[i]) {
                nextBigIndex[queue.pollLast()] = i;
            }
            queue.offerLast(i);
            i++;
        }
        while (!queue.isEmpty()) {
            Integer index = queue.poll();
            nextBigIndex[index] = index;//没找到比它大的，为它自己
        }
        List<Integer> res = new ArrayList<>();
        for (int j = 0; j < n; j++) {
            int canGet = 0;
            if (j == nextBigIndex[j]) {
                canGet = infos[j];
            } else {
                canGet = (nextBigIndex[j] - j) * (infos[nextBigIndex[j]] - infos[j]);
            }
            res.add(canGet);
        }
        return res;
    }

    /*
            双重 for 暴力
                n 范围 1...10000
                    可能超时
     */
    private static List<Integer> handle1(int[] infos, int n) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int canGet = infos[i];
            for (int j = i + 1; j < n; j++) {
                if (infos[i] < infos[j]) {
                    canGet = (j - i) * (infos[j] - infos[i]);
                    break;
                }
            }
            res.add(canGet);
        }
        return res;
    }

    public static ArrayList<Integer> handle3(int[] arr, int m) {
        LinkedList<Integer[]> stack = new LinkedList<>();
        Integer[] nextBigger = new Integer[m];
        Arrays.fill(nextBigger, -1);

        for (int i = 0; i < arr.length; i++) {
            while (stack.size() > 0) {
                Integer[] top = stack.peek();
                int idx = top[0];
                int val = top[1];

                if (arr[i] > val) {
                    stack.pop();
                    nextBigger[idx] = i;
                } else {
                    break;
                }
            }

            Integer[] ele = {i, arr[i]};
            stack.push(ele);
        }

        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            Integer idx = nextBigger[i];

            if (idx == -1) {
                ans.add(arr[i]);
            } else {
                ans.add((idx - i) * (arr[idx] - arr[i])); // 距离 * 数字差值
            }
        }

//        StringJoiner sj = new StringJoiner(" ", "", "");
//        for (Integer an : ans) sj.add(an + "");
        return ans;
    }

}


