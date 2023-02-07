package algorithm777.h.s200;

import java.util.*;

/**
 * @Author: permission
 * @Date: 2023/2/8 2:30
 * @Version: 1.0
 * @ClassName: H5_89_修建高铁最优成本_最优高铁城市修建方案
 * @Description: 200
 */
public class H5_89_修建高铁最优成本_最优高铁城市修建方案 {

    public static void main(String[] args) {
/*

3 3 0
1 2 10
1 3 100
2 3 50
期望输出：60

3 3 1
1 2 10
1 3 100
2 3 50
1 3
期望输出：110
 */
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();//n个城市
        int m = scanner.nextInt();//m条高铁
        int k = scanner.nextInt();//必建的高铁列表数
        int[][] cost = new int[m][3];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 3; j++) {
                cost[i][j] = scanner.nextInt();
            }
        }
        int[][] must = new int[k][2];
        if (k > 0) {
            for (int i = 0; i < k; i++) {
                for (int j = 0; j < 2; j++) {
                    must[i][j] = scanner.nextInt();
                }
            }
        }
        int res = handle_k(n, m, cost, must);
        System.out.println(res);
    }

    /*
            k算法 + 并查集
     */
    private static int handle_k(int n, int m, int[][] cost, int[][] must) {
        UnionFind unionFind = new UnionFind(n);
//        Set<Integer> set = new HashSet<>();//已经通高铁的城市
        Arrays.sort(cost, (Comparator.comparingInt(o -> o[2])));
        int min_cost = 0;
        if (must.length > 0) {
            for (int i = 0; i < must.length; i++) {
                int[] mus = must[i];
                for (int j = 0; j < m; j++) {
                    if (cost[j][0] == mus[0] && cost[j][1] == mus[1]) {
                        int[] edge = cost[j];
                        unionFind.union(edge[0], edge[1]);//这里不用判断成环，因为必须修建
                        min_cost += edge[2];
//                        set.add(edge[0]);//将已经通高铁的城市加入set
//                        set.add(edge[1]);//将已经通高铁的城市加入set
                    }
                }
            }
        }
        for (int i = 0; i < m; i++) {
            int[] edge = cost[i];
            if (unionFind.find(edge[0]) != unionFind.find(edge[1])) {//不在同一个集合（未连通）
                min_cost += edge[2];
                unionFind.union(edge[0], edge[1]);
//                set.add(edge[0]);//将已经通高铁的城市加入set
//                set.add(edge[1]);//将已经通高铁的城市加入set
            }
//            if (set.size() == n) {
//                return min_cost;
//            }
            if (unionFind.size == 2) {//和用set记录所有点一样，如果并查集只有一个集合，说明所有点都已连同
                return min_cost;//等于2是因为并查集从0开始，题中城市从1开始，所以并查集中0号位置多余
            }
        }
        return min_cost;
    }

    public static class UnionFind {
        int[] parent;
        int[] size_i;
        int size;

        public UnionFind(int n) {
            this.parent = new int[n + 1];
            this.size_i = new int[n + 1];
            this.size = n + 1;
            for (int i = 0; i <= n; i++) {
                parent[i] = i;
                size_i[i] = 1;
            }
        }

        public int find(int i) {
            while (parent[i] != i) {
                i = find(parent[i]);
            }
            return i;
        }

        public void union(int i, int j) {
            int i_parent = parent[i];
            int j_parent = parent[j];
            if (size_i[i_parent] >= size_i[j_parent]) {
                parent[j_parent] = i_parent;
                size_i[i_parent] += size_i[j_parent];
            } else {
                parent[i_parent] = j_parent;
                size_i[j_parent] += size_i[i_parent];
            }
            size--;
        }
    }


}
