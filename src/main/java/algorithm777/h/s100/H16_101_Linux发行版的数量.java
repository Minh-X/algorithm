package algorithm777.h.s100;

import java.util.Scanner;

/**
 * @Author: permission
 * @Date: 2023/2/10 16:46
 * @Version: 1.0
 * @ClassName: H16_101_Linux发行版的数量
 * @Description: 100
 */
public class H16_101_Linux发行版的数量 {

    public static void main(String[] args) {
/*
4
1 1 0 0
1 1 1 0
0 1 1 0
0 0 0 1
期望：3

4
1 1 1 1
1 1 1 0
1 1 1 0
1 0 0 1
期望：4
 */
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] relations = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                relations[i][j] = scanner.nextInt();
            }
        }
//        int res = handle(relations, n);
//        System.out.println(res);
        System.out.println(Integer.MAX_VALUE);
        System.out.println((int) Math.pow(10,7));
    }

    private static int handle(int[][] relations, int n) {
        UnionFind unionFind = new UnionFind(n);
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (relations[i][j] == 1) {
                    unionFind.union(i, j);
                }
            }
        }
        int max = unionFind.size[1];
        for (int i = 2; i <= n; i++) {
            max = Math.max(max, unionFind.size[i]);
        }
        return max;
    }

    private static class UnionFind {
        int[] parent;
        int[] size;
        int count;

        public UnionFind(int n) {
            this.parent = new int[n + 1];
            this.size = new int[n + 1];
            this.count = n;
            for (int i = 1; i <= n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int find(int i) {
            if (i != parent[i]) {
                i = parent[i];
            }
            return i;
        }

        public void union(int x, int y) {
            int xp = find(x);
            int yp = find(y);
            if (xp != yp) {
                count--;//合并
                if (size[xp] >= size[yp]) {
                    parent[y] = xp;
                    size[xp] += size[yp];
                } else {
                    parent[x] = yp;
                    size[yp] += size[xp];
                }
            }
        }

        public int getSize(int x) {
            return size[x];
        }
    }
}
