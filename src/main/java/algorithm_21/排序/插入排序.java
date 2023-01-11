package algorithm_21.排序;

import java.util.Arrays;

/**
 * @Author: permission
 * @Date: 2022/9/20 18:46
 * @Version: 1.0
 * @ClassName: 插入排序
 * @Description:
 */
public class 插入排序 {
    public static void main(String[] args) {
        int[] a = {5, 8, 3, 4, 9, 7, 1};
        Arrays.stream(f1(a)).forEach(System.out::print);
    }

    private static int[] f1(int[] a) {
        int[] arr = Arrays.copyOf(a, a.length);

        for (int i = 1; i < a.length; i++) {
            // 记录要进行插入的数
            int temp = arr[i];
            // 从已经有序的右边开始比较
            int j = i;
            while (j > 0 && temp < arr[j - 1]) {
                // 将比temp大的 右移一位
                arr[j] = arr[j - 1];
                j--;
            }
            // 存在比其小的数，插入（如果j的值改变了，说明前面有序的列表中有大于temp的）
            if (j != i) {
                arr[j] = temp;
            }
        }

        return arr;
    }
}
