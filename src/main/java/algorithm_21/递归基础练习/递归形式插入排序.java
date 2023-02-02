package algorithm_21.递归;

import java.util.Scanner;

/**
 * @author permission
 * @Date 2021 - 07 - 11 - 20:46
 * @package algorithm.递归基础练习
 * @Description:
 */
public class 递归形式插入排序 {
    public void f1(int[] arr, int n){
        if (n == 0){
            return;
        }
        f1(arr,arr.length-1);
        int x = arr[n];
        int index = n-1;
        while (x < arr[index]){
            arr[index+1] = arr[index];
            index--;
        }
        arr[index+1] = x;
    }

    public static void main(String[] args) {
        递归形式插入排序 obj = new 递归形式插入排序();
        Scanner scanner = new Scanner(System.in);
        System.out.print("输入数组长度：");
        int n = scanner.nextInt();
        System.out.print("输入一个数组：");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
    }
}
