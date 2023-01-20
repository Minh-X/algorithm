package algorithm7.leetcode.并查集;

/**
 * @Author: permission
 * @Date: 2023/1/19 2:07
 * @Version: 1.0
 * @ClassName: LC547
 * @Description: 547. 省份数量
 */
public class LC547 {

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        UnionFind unionFind = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    unionFind.union(i, j);
                }
            }
        }
        return unionFind.getSetsNum();
    }


    //定义并查集
    public static class UnionFind {
        private int[] parent;// parent[i]=k 表示i的父亲是k
        private int[] size;// size[i]=k 如果i是代表节点（parent指向自己）才有意义，表示集合i的大小
        private int[] help;//辅助结构
        private int setsNum;//一共有多少个集合

        public UnionFind(int n) {
            this.parent = new int[n];
            this.size = new int[n];
            this.help = new int[n];
            this.setsNum = n;
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        //从i开始，一直向上找，找到代表节点，返回
        private int find(int i) {
//            int hi = 0;
//            while (i != parent[i]) {
//                help[hi++] = i;
//                i = parent[i];
//            }
//            for (hi--; hi >= 0; hi--) {
//                parent[help[hi]] = i;
//            }
            while (i!=parent[i]) {
                i = parent[i];
            }

            return i;
        }

        public void union(int i, int j) {
            int f1 = find(i);
            int f2 = find(j);
            if (f1 != f2) {
                if (size[f1]>=size[f2]) {
                    size[f1]+=size[f2];
                    parent[f2]=f1;
                } else {
                    size[f2] += size[f1];
                    parent[f1] = f2;
                }
                setsNum--;
            }
        }

        public int getSetsNum() {
            return setsNum;
        }
    }

}
