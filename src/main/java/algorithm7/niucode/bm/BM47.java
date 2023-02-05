package algorithm7.niucode.bm;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author: permission
 * @Date: 2023/2/5 18:47
 * @Version: 1.0
 * @ClassName: BM47
 * @Description: BM47 寻找第K大
 */
public class BM47 {


    public static void main(String[] args) {
        int[] a = {10,10,9,9,8,7,5,6,4,3,4,2};
        int n = 5;
        int k = 3;
        int res = findKth(a, n, k);
        System.out.println(res);
    }

    public static int findKth(int[] a, int n, int K) {
        if (a == null || a.length == 0 || a.length < K) {
            return -1;
        }
        return handle1(a, n, K);
    }

    private static int handle1(int[] a, int n, int k) {
        Arrays.stream(a).distinct();
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i : a) {
            heap.add(i);
        }
        for (int i = 0; i < k - 1; i++) {
            heap.poll();
        }
        return heap.poll();
    }
}
