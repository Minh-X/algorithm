package algorithm_21.排序;

import java.util.Arrays;

/**
 * @Author: permission
 * @Date: 2022/9/20 20:08
 * @Version: 1.0
 * @ClassName: 快速排序
 * @Description:
 */
public class 快速排序 {

    public static void main(String[] args) {
        int[] nums = {34, 77, 31, 24, 35, 32, 50, 54, 76};
        System.out.println("快速排序前:" + Arrays.toString(nums));
        int[] res = nums.clone();
        q7(res, 0, res.length - 1);
        System.out.println("快速排序后:" + Arrays.toString(res));

        q1(nums, 0, nums.length - 1);
        System.out.println("快速排序后:" + Arrays.toString(nums));
    }

    private static void q7(int[] res, int start, int end) {
        if (start > end) {
            return;
        }
        int i, j, base;
        i = start;
        j = end;
        base = res[start];
        while (i < j) {
            //这里有个坑,要先从右开始往左找,不然排序后位置不对(从base的对面开始)
            while (i < j && res[j] >= base) j--;//从右往左找第一个小于base的数的下标
            while (i < j && res[i] <= base) i++;//从左往右找第一个大于base的数的下标(小于等于 i++)
            if (i < j) {
                swap(res, i, j);
            }
        }
        swap(res, start, i);
        q7(res, start, i - 1);
        q7(res, i + 1, end);

    }

    public static void quickSort(int[] nums, int start, int end) {
        if (start > end) return;
        int i, j, base;
        i = start;
        j = end;
        base = nums[start];
        while (i < j) {
            while (i < j && nums[j] >= base) j--;
            while (i < j && nums[i] <= base) i++;
            if (i < j) {
                swap(nums, i, j);
            }
        }
        swap(nums, start, i);
        quickSort(nums, start, j - 1);
        quickSort(nums, j + 1, end);
    }

    // 和 quickSort 一样（复习 重写一遍）
    public static void q1(int[] arr, int start, int end) {
        if (start > end) return;
        int i, j, base;
        i = start;
        j = end;
//        base = arr[i];
        base = arr[i];
        while (i < j) {
            while (i < j && arr[j] >= base) j--;
            while (i < j && arr[i] <= base) i++;
            if (i < j) {
                swap(arr, i, j);
            }
        }
        swap(arr, start, i);
        q1(arr, start, j - 1);
        q1(arr, j + 1, end);

    }


    public static void q2(int[] arr, int start, int end) {
        if (start > end) return;
        int i, j, base;
        i = start;
        j = end;
        base = arr[i];
        while (i < j) {
            while (i < j && arr[j] >= base) j--;
            while (i < j && arr[i] <= base) i++;
            if (i < j) {
                swap(arr, i, j);
            }
        }
    }

    public static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }


//    public static void main(String[] args) {
//        int[] a = {77, 24, 5, 32, 50, 34, 54, 76};
//        System.out.println("快速排序前:" + Arrays.toString(a));
//        quickSort(a, 0, a.length - 1);
//        System.out.println("快速排序后:" + Arrays.toString(a));
//    }
//
//
//    private static int[] quickSort(int[] a, int start, int end) {
//        int[] arr = Arrays.copyOf(a, a.length);
//        if (start > end) return null;
//
//        int i = start;
//        int j = end;
//        int sentry = arr[start];
//        while (i < j) {
//            while (i < j && arr[j] >= sentry) j--;
//            while (i < j && arr[i] <= sentry) i++;
//            if (i < j) {
//                MyUtil.swap(arr, i, j);
//            }
//        }
//        MyUtil.swap(arr, i, j);
//        quickSort(arr, start, i);
//        quickSort(arr, j+1, end);
//        return arr;
//    }

}
