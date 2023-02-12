package algorithm777.h7.s200;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

//public class H1_无向图染色 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        int m = sc.nextInt();
//        int n = sc.nextInt();
//
//        int[][] edges = new int[n][2];
//        for (int i = 0; i < n; i++) {
//            edges[i][0] = sc.nextInt();
//            edges[i][1] = sc.nextInt();
//        }
//
//        System.out.println(getResult(edges, m));
//    }
//
//    /**
//     * @param edges 边，即[v1, v2]
//     * @param m 点数量
//     * @return
//     */
//    public static int getResult(int[][] edges, int m) {
//        // connect用于存放每个节点的相邻节点
//        HashMap<Integer, HashSet<Integer>> connect = new HashMap<>();
//
//        for (int[] edge : edges) {
//            connect.putIfAbsent(edge[0], new HashSet<>());
//            connect.get(edge[0]).add(edge[1]);
//
//            connect.putIfAbsent(edge[1], new HashSet<>());
//            connect.get(edge[1]).add(edge[0]);
//        }
//
//        // 节点从index=1开始，必有count=1个的全黑染色方案
//        return dfs(connect, m, 1, 1, new LinkedList<>());
//    }
//
//    // 该方法用于求解给定多个节点染红的全组合数
//    public static int dfs(
//            HashMap<Integer, HashSet<Integer>> connect,
//            int m,
//            int index,
//            int count,
//            LinkedList<HashSet<Integer>> path) {
//        if (path.size() == m) return count;
//
//        outer:
//        for (int i = index; i <= m; i++) {
//            // 如果新加入节点i和已有节点j相邻，则说明新加入节点不能染成红色，需要进行剪枝
//            for (HashSet<Integer> p : path) {
//                if (p.contains(i)) continue outer;
//            }
//
//            count++;
//
//            path.addLast(connect.get(i));
//            count = dfs(connect, m, i + 1, count, path);
//            path.removeLast();
//        }
//
//        return count;
//    }
//}


/**
 * @Author: permission
 * @Date: 2023/2/11 14:03
 * @Version: 1.0
 * @ClassName: H1_无向图染色
 * @Description: 200
 */
public class H1_无向图染色 {

    public static void main(String[] args) {
/*
4 4
1 2
2 4
3 4
1 3
期望输出：7
 */
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
//        int[][] edges = new int[m + 1][m + 1];
//        for (int i = 1; i <= n; i++) {
//            int x = scanner.nextInt();
//            int y = scanner.nextInt();
//            edges[x][y] = 1;
//        }
        int[][] edges = new int[n][2];
        for (int i = 0; i < n; i++) {
            edges[i][0] = scanner.nextInt();
            edges[i][1] = scanner.nextInt();
        }

        int res = handle(edges, m, n);
//        int res = getResult(edges, m);

        System.out.println(res);
    }

    private static int handle(int[][] edges, int m, int n) {
        HashMap<Integer, HashSet<Integer>> connect = new HashMap<>();//k为点，v为与它相邻的点
        for (int[] edge : edges) {
            connect.putIfAbsent(edge[0], new HashSet<>());
            connect.putIfAbsent(edge[1], new HashSet<>());

            connect.get(edge[0]).add(edge[1]);//无向图，两边都要加
            connect.get(edge[1]).add(edge[0]);
        }
        //res初始为1，表示无红色节点（一种染色方案）
        //从1号节点，递归染色
        return dfs(connect, m, 1, 1, new LinkedList<>());
    }

    private static int dfs(HashMap<Integer, HashSet<Integer>> connect, int m, int index, int res, LinkedList<HashSet<Integer>> path) {
        if (path.size() == m) {//所有节点已经染色
            return res;
        }

        outer:
        for (int i = index; i <= m; i++) {
            for (HashSet<Integer> p : path) {
                if (p.contains(i)) {//如果是index的相邻节点，跳过
                    continue outer;
                }
            }
            res++;//染色

            path.addLast(connect.get(i));//将染色的点的相邻点加入集合，下次跳过
            res = dfs(connect, m, index + 1, res, path);//去下一个节点染色
            path.removeLast();
        }

        return res;
    }


//    /**
//     * @param edges 边，即[v1, v2]
//     * @param m     点数量
//     * @return
//     */
//    public static int getResult(int[][] edges, int m) {
//        // connect用于存放每个节点的相邻节点
//        HashMap<Integer, HashSet<Integer>> connect = new HashMap<>();
//
//        for (int[] edge : edges) {
//            connect.putIfAbsent(edge[0], new HashSet<>());
//            connect.get(edge[0]).add(edge[1]);
//
//            connect.putIfAbsent(edge[1], new HashSet<>());
//            connect.get(edge[1]).add(edge[0]);
//        }
//
//        // 节点从index=1开始，必有count=1个的全黑染色方案
//        return dfs2(connect, m, 1, 1, new LinkedList<>());
//    }
//
//    // 该方法用于求解给定多个节点染红的全组合数
//    public static int dfs2(
//            HashMap<Integer, HashSet<Integer>> connect,
//            int m,
//            int index,
//            int count,
//            LinkedList<HashSet<Integer>> path) {
//        if (path.size() == m) return count;
//
//        outer:
//        for (int i = index; i <= m; i++) {
//            // 如果新加入节点i和已有节点j相邻，则说明新加入节点不能染成红色，需要进行剪枝
//            for (HashSet<Integer> p : path) {
//                if (p.contains(i)) continue outer;
//            }
//
//            count++;
//
//            path.addLast(connect.get(i));
//            count = dfs2(connect, m, i + 1, count, path);
//            path.removeLast();
//        }
//
//        return count;
//    }
}

