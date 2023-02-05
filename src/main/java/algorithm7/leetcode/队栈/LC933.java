package algorithm7.leetcode.队栈;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: permission
 * @Date: 2023/2/5 17:50
 * @Version: 1.0
 * @ClassName: LC933
 * @Description: 933. 最近的请求次数
 */
public class LC933 {


class RecentCounter {

    Queue<Integer> queue;

    public RecentCounter() {
        queue = new LinkedList<>();
    }

    public int ping(int t) {
        queue.offer(t);
        while (queue.peek() < t - 3000) {
            queue.poll();
        }
        return queue.size();
    }

}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */


}
