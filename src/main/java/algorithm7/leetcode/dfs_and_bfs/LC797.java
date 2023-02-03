package algorithm7.leetcode.dfs_and_bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Author: permission
 * @Date: 2023/2/3 20:07
 * @Version: 1.0
 * @ClassName: LC797
 * @Description: 797. 所有可能的路径
 */
public class LC797 {

    public static void main(String[] args) {
        int[][] graph = {{1, 2}, {3}, {3}, {}};
        allPathsSourceTarget(graph);
    }


    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
//        ArrayList<Integer> cur = new ArrayList<>();
//        cur.add(0);
//        dfs2(0, graph.length - 1, graph, res, cur);


        Deque<Integer> deque = new ArrayDeque<>();
        deque.offerLast(0);
        dfs(0, graph.length - 1, graph, res, deque);

        return res;
    }

    private static void dfs(int start, int end, int[][] graph, List<List<Integer>> res, Deque<Integer> deque) {
        if (start == end) {
            res.add(new ArrayList<>(deque));
            return;
        }
        for (int j : graph[start]) {
            deque.offerLast(j);
            dfs(j, end, graph, res, deque);
            deque.pollLast();
        }
    }


    private static void dfs2(int start, int end, int[][] graph, List<List<Integer>> res, ArrayList<Integer> cur) {
        if (start == end) {
            List<Integer> clone = (List<Integer>) cur.clone();
            res.add(clone);
            return;
        }
        int Col = graph[start].length;
        if (Col >= 0) {
            for (int j = 0; j < Col; j++) {
                cur.add(graph[start][j]);
                dfs2(graph[start][j], end, graph, res, cur);
                for (int i = 1; i < cur.size(); i++) {
                    cur.remove(i);
                }
            }
        }
    }
}
