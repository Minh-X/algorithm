package algorithm777.h7.s200;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @Author: permission
 * @Date: 2023/2/14 18:53
 * @Version: 1.0
 * @ClassName: H18_基站维护工程师
 * @Description: 200
 */
public class H18_基站维护工程师 {

    public static void main(String[] args) {
/*
3
0 2 1
1 0 2
2 1 0
期望输出：3

10
0 1 1 1 1 1 1 1 1 1
1 0 1 1 1 1 1 1 1 1
1 1 0 1 1 1 1 1 1 1
1 1 1 0 1 1 1 1 1 1
1 1 1 1 0 1 1 1 1 1
1 1 1 1 1 0 1 1 1 1
1 1 1 1 1 1 0 1 1 1
1 1 1 1 1 1 1 0 1 1
1 1 1 1 1 1 1 1 0 1
1 1 1 1 1 1 1 1 1 0

 */
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = scanner.nextInt();
            }
        }
        long start = System.currentTimeMillis();
        int res = handle(graph, n);
        long end = System.currentTimeMillis();
        System.out.println(res);
        System.out.println("耗时：" + (end - start));
    }

    /*
            每两个基站之间都有距离，基站数量n最大为10，也就是10*10的矩阵，直接用全排列暴力枚举
                如当 n = 3 时，枚举 2...3 两个站点的可能路线（枚举2...n的全排列）
                    结果：第一种可能： 1 -> 2 -> 3 -> 1
                         第二种可能： 1 -> 3 -> 2 -> 1 ，取最短的路径和
     */
    private static int handle(int[][] graph, int n) {
        ArrayList<ArrayList<Integer>> allPaths = new ArrayList<>();
        ArrayList<Integer> curPath = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            curPath.add(i);
        }
        dfs(0, n - 1, curPath, allPaths);//求全排列，结果放在 allPaths
        int min = Integer.MAX_VALUE;
        for (ArrayList<Integer> path : allPaths) {
            //求每种路径的路径，取最小的为结果
            int cur = graph[0][path.get(0)];
            for (int i = 0; i < path.size() - 1; i++) {
                cur += graph[path.get(i)][path.get(i + 1)];
            }
            cur += graph[path.get(path.size() - 1)][0];
            min = Math.min(min, cur);
        }
        return min;
    }

    private static void dfs(int index, int n, ArrayList<Integer> curPath, ArrayList<ArrayList<Integer>> allPaths) {
        if (index == n) {
            allPaths.add((ArrayList<Integer>) curPath.clone());
            return;
        }
        //求全排列
        for (int i = index; i < n; i++) {
            Collections.swap(curPath, index, i);//交换
            dfs(index + 1, n, curPath, allPaths);//去下一个点
            Collections.swap(curPath, index, i);//恢复现场
        }
    }
}
