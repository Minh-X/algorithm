package algorithm_21.排序;


import java.util.Arrays;

/**
 * @Author: permission
 * @Date: 2022/9/20 18:11
 * @Version: 1.0
 * @ClassName: 选择排序
 * @Description:
 */
public class 选择排序 {

    public static void main(String[] args) {
        int[] a = {1,3,2,7,6,4};
        Arrays.stream(f1(a)).forEach(System.out::print);
        System.out.println();
        Arrays.stream(f2(a)).forEach(System.out::print);
    }

    private static int[] f2(int[] a) {
        int[] arr = a.clone();
        int minIndex;
        int temp;
        for (int i = 0; i < arr.length; i++) {
            minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
        return arr;
    }

    private static int[] f1(int[] a) {
        int[] arr = a.clone();
        int minIndex;
        int temp;
        for (int i = 0; i < arr.length; i++) {
            minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
        return arr;
    }
}
