package algorithm_21.util;

/**
 * @author permission
 * @Date 2021 - 06 - 07 - 10:58
 * @package algorithm.util
 * @Description:
 */
public class MyUtil {
    /**
     * 交换数组中的两个指定元素的位置
     * @param a 数组名
     * @param x 要进行交换的其中一个元素的下标
     * @param y 要进行交换的另一个元素的下标
     */
    public static void swap(int[] a,int x,int y) {
        int temp;
        temp=a[x];
        a[x]=a[y];
        a[y]=temp;
    }

    /**
     * 输出数组内容（整型数组）
     * @param arr 需要输出的数组名称
     */
    public static void printArr(int[] arr){
        System.out.print("[ ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.print("]");
        System.out.println();
    }
}
