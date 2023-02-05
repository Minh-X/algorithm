package algorithm7.niucode.bm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @Author: permission
 * @Date: 2023/2/5 18:00
 * @Version: 1.0
 * @ClassName: BM46
 * @Description: BM46 最小的K个数
 */
public class BM46 {

    public static void main(String[] args) {
        int k = 4;
        int[] input = {4, 5, 1, 6, 2, 7, 3, 8};
        ArrayList<Integer> res = GetLeastNumbers_Solution(input, k);
        for (Integer r : res) {
            System.out.print(r + " ");
        }
    }

    public static ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        if (input == null || input.length == 0 || k > input.length) {
            return new ArrayList<>();
        }
//        return handle_recursion(input, k);
//        return handle_sorted(input, k);
        return handle_heapSort(input, k);
    }

    /*
            堆排序
                O(n * logk)
     */
    private static ArrayList<Integer> handle_heapSort(int[] input, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i : input) {
            heap.add(i);
        }
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            res.add(heap.poll());
        }
        return res;
    }

    /*
            直接排序
                O(n * log2n)
     */
    private static ArrayList<Integer> handle_sorted(int[] input, int k) {
        Arrays.sort(input);
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            res.add(input[i]);
        }
        return res;
    }

    /*
            暴力，每次找最小，找k次
                O(k*n)
     */
    private static ArrayList<Integer> handle_recursion(int[] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        int n = input.length;
        for (int i = 0; i < k; i++) {
            int min_value = input[0];
            int min_index = 0;
            for (int j = 1; j < n; j++) {
                if (min_value > input[j]) {
                    min_value = input[j];
                    min_index = j;
                }
            }
            res.add(min_value);
            input[min_index] = Integer.MAX_VALUE;
        }
        return res;
    }

}
