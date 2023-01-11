package algorithm_21.排序;



import algorithm_21.util.MyUtil;
import java.util.Scanner;

/**
 * @author permission
 * @Date 2021 - 07 - 12 - 0:34
 * @package algorithm.排序
 * @Description:
 */
public class 希尔排序 {
    public void shellSort(int[] arr) {
        for (int i = arr.length / 2; i > 0; i = i / 2) {//增量
            for (int j = 0; j < arr.length; j++) {
                int target = arr[j];
                int k = j - i;
                while (k > -1 && target < arr[k]) {
                    arr[k + i] = arr[k];
                    k -= i;
                }
                arr[k+i] = target;
            }
        }
        MyUtil.printArr(arr);
    }

    public static void main(String[] args) {
        希尔排序 obj = new 希尔排序();
        Scanner scanner = new Scanner(System.in);
        int n = 0;
        System.out.print("输入数组长度：");
        n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("输入一个场长度为" + n + "的数组：");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        obj.shellSort(arr);
    }
}
