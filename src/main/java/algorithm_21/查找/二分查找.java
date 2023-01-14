package algorithm_21.查找;

import java.util.Scanner;

/**
 * 二分查找
 * @author permission
 * @Date 2021 - 07 - 11 - 23:51
 * @package algorithm.查找
 * @Description:
 */
public class 二分查找 {

    // 非递归
    public int binarySearch2(int[] arr, int size, int key) {
        int L = 0;
        int R = size - 1;
        while (L <= R) {
            int mid = (L + R) / 2;
            if (key == arr[mid]) {
                return mid;
            } else if (key < arr[mid]) {
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return -1;
    }

    //递归
    public int binarySearch(int[] arr, int low, int high, int key){
        if (low <= high){
            int mid = (low + high)/2;
            int midValue = arr[mid];
            if (midValue < key){
                return binarySearch(arr, mid+1, high, key);
            }
            else if (midValue > key){
                return binarySearch(arr, low, mid-1, key);
            }
            else if (midValue == key) {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        二分查找 obj = new 二分查找();
        Scanner scanner = new Scanner(System.in);
        int n = 0;
        System.out.print("输入数组长度：");
        n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("输入一个场长度为" + n + "的升序数组：");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.print("输入要查找的值：");
        int key = scanner.nextInt();
        int result = obj.binarySearch(arr,0, n, key);
        int result2 = obj.binarySearch2(arr, n, key);
        System.out.println(result);
        System.out.println(result2);
    }
}
