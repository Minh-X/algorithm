package algorithm7.niucode.nc.图.最小生成树.kruskal;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: permission
 * @Date: 2023/2/8 1:19
 * @Version: 1.0
 * @ClassName: NC157
 * @Description: NC159 最小生成树
 */
public class NC159 {

    public static void main(String[] args) {
        int n = 3;
        int m = 3;
        int[][] cost = {{1, 3, 3}, {1, 2, 1}, {2, 3, 1}};
        int res = miniSpanningTree(n, m, cost);
        System.out.println(res);
    }

    /**
     * @param n    n户
     * @param m    m条路
     * @param cost 表示第i户到第j户修路的的花费
     * @return
     */
    public static int miniSpanningTree(int n, int m, int[][] cost) {
        return handle_k(n, m, cost);
    }

    private static int handle_k(int n, int m, int[][] cost) {
        unionFind unionFind = new unionFind(n);
        Arrays.sort(cost, Comparator.comparingInt(o -> o[2]));//按cost升序排序
        int min_cost = 0;
        for (int i = 0; i < m; i++) {//遍历边，每次取最小的看是否形成环，形成环则抛弃
            int[] edge = cost[i];
            if (unionFind.find(edge[0]) != unionFind.find(edge[1])) {//未形成环
                unionFind.union(edge[0], edge[1]);
                min_cost += edge[2];//要修这条路，加上这条路的花费
            }
        }
        return min_cost;
    }

    public static class unionFind {
        int[] parent;
        int[] size_i;//代表节点的大小
        int size;//集合大小

        public unionFind(int n) {
            this.parent = new int[n + 1];
            this.size_i = new int[n + 1];
            this.size = n;
            for (int i = 0; i <= n; i++) {
                parent[i] = i;
                size_i[i] = 1;
            }
        }

        public int find(int i) {
            while (i != parent[i]) {
                i = parent[i];
            }
            return i;
        }

        public void union(int i, int j) {
            int i_parent = find(i);
            int j_parent = find(j);
            if (i_parent != j_parent) {//不在同一个
                if (size_i[i_parent] >= size_i[j_parent]) {//小的合到大的下面
                    parent[j_parent] = i_parent;
                    size_i[i_parent] += size_i[j_parent];
                } else {
                    parent[i_parent] = j_parent;
                    size_i[j_parent] += size_i[i_parent];
                }
                size--;//总的集合数量减1
            }
        }
    }
}
