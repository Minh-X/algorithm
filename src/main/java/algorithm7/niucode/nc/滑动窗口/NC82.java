package algorithm7.niucode.nc.滑动窗口;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: permission
 * @Date: 2023/2/3 2:45
 * @Version: 1.0
 * @ClassName: JZ59
 * @Description: NC82 滑动窗口的最大值
 */
public class NC82 {

    public static ArrayList<Integer> maxInWindows(int[] num, int size) {
        if (num == null || size < 1 || num.length < size) {
            return new ArrayList<>();
        }
//        return handle_voilence(num, size);
        return handle_deque(num, size);
    }

    /*
            双端队列
     */
    private static ArrayList<Integer> handle_deque(int[] num, int size) {
        ArrayList<Integer> res = new ArrayList<>();
        Deque<Integer> queue = new LinkedList<>();//放下标（按值从大到小排序）
        for (int R = 0; R < num.length; R++) {
            while (!queue.isEmpty() && num[R] >= num[queue.peekLast()]) {//如果queue不为空，将所有不大于num[R]的出队（因为前面的比它小，过期时间还比它早，不可能取到，直接丢弃即可）
                queue.pollLast();
            }
            queue.addLast(R);
            if (queue.peekFirst() == R - size) {//R-size表示过期下标，如果过期，头出队   例如：R=0时，R-size=-3，此时下标为3的过期（queue里存的下标）
                queue.pollFirst();
            }
            if (R >= size - 1) {//窗口大小是否达到size？达到了，才开始记录答案
                res.add(num[queue.peekFirst()]);//不出队，只将最大值记录到res
            }
        }
        return res;
    }

    /*
            暴力（超时）
     */
    private static ArrayList<Integer> handle_voilence(int[] num, int size) {
        int N = num.length;
        ArrayList<Integer> res = new ArrayList<>();
        int index = 0;
        int L = 0;//左指针
        int R = size - 1;//右指针
        while (R < N) {
//            int max = 0;
//            for (int i = L; i < R; i++) {
//                max = Math.max(arr[i], arr[i + 1]) > max ? Math.max(arr[i], arr[i + 1]) : max;
//            }
            int max = num[L];
            for (int i = L + 1; i <= R; i++) {
                max = Math.max(max, num[i]);
            }
            res.add(max);
            index++;
            L++;
            R++;
        }
        return res;
    }




    public static void main(String[] args) {
        int[] a = {2, 3, 4, 2, 6, 2, 5, 1};
        int size = 3;
        ArrayList<Integer> list = maxInWindows(a, size);
        if (list != null) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
        }
        System.out.println();
        System.out.println("---------------");
    }
}
