package algorithm_21.排序;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PrimitiveIterator;

/**
 * @Author: permission
 * @Date: 2021/9/10 15:10
 * @Version: 1.0
 * @ClassName: 冒泡排序
 * @Description:
 */
public class 冒泡排序 {
    static void f1(int[] arr) {
        int temp = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length-i-1; j++) {
                if (arr[j]>arr[j+1]) {
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    static int[] f2(int[] a) {
        // 使用 clone 方法，直接 arr = a，操作 arr，a 中的数据也会变
        int[] arr = a.clone();

        int temp = 0;
        // 一次遍历是否交换顺序
        boolean isOrdered = true;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j+1]) {
                    temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                    // 交换过位置，表示无序
                    isOrdered = false;
                }
            }
            if (isOrdered) break;
        }


        return arr;
    }


    public static void main(String[] args) {
        int[] a = new int[]{6, 3, 8, 2, 9, 1};

        Arrays.stream(f2(a)).forEach(System.out::print);
        System.out.println();

        Arrays.stream(a).forEach(System.out::print);
        System.out.println();


        f1(a);
        PrimitiveIterator.OfInt iterator = Arrays.stream(a).iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.nextInt());
        }
    }
}
