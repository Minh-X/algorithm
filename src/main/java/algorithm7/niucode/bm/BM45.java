package algorithm7.niucode.bm;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: permission
 * @Date: 2023/2/5 17:57
 * @Version: 1.0
 * @ClassName: BM45
 * @Description: BM45 滑动窗口的最大值
 */
public class BM45 {

    public static void main(String[] args) {
        int[] num = {2, 3, 4, 2, 6, 2, 5, 1};
        int size = 3;
        ArrayList<Integer> res = maxInWindows(num, size);
        for (Integer r : res) {
            System.out.print(r + " ");
        }
    }

    public static ArrayList<Integer> maxInWindows(int[] num, int size) {
        if (num == null || size < 1 || num.length < size) {
            return new ArrayList<>();
        }
//        return handle_voilence(num, size);
        return handle_deque(num, size);
    }

    private static ArrayList<Integer> handle_deque(int[] num, int size) {
        int n = num.length;
        ArrayList<Integer> res = new ArrayList<>();
        int r = 0;
        int l = r - size + 1;
        Deque<Integer> deque = new LinkedList<>();
        while (r < n) {
            while (!deque.isEmpty() && num[deque.peekLast()] < num[r]) {
                deque.pollLast();
            }
            deque.offerLast(r);

            if (l >= 0) {
                while (deque.peekFirst() < l) {
                    deque.poll();
                }
                res.add(num[deque.peekFirst()]);
            }
            r++;
            l++;
        }
        return res;
    }
}
