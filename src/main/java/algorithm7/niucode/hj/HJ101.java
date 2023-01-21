package algorithm7.niucode.hj;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: permission
 * @Date: 2023/1/22 0:20
 * @Version: 1.0
 * @ClassName: HJ101
 * @Description: HJ101 输入整型数组和排序标识，对其元素按照升序或降序进行排序
 */
public class HJ101 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            int[] arr = new int[n];
            int temp;
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                temp = in.nextInt();
                arr[i] = temp;
                list.add(temp);
            }
            int sortedType = in.nextInt();//0升序，1降序
            mySorted(arr, list, sortedType);
        }
    }

    private static void mySorted(int[] arr, List<Integer> list, int sortedType) {
        List<Integer> resList = null;
        if (sortedType == 0) {
            resList = list.stream().sorted(new MyComparator0()).collect(Collectors.toList());
        } else if (sortedType == 1) {
            resList = list.stream().sorted(new MyComparator1()).collect(Collectors.toList());
        }
        int i;
        for (i=0; i < resList.size() - 1; i++) {
            System.out.print(resList.get(i) + " ");
        }
        System.out.print(resList.get(i));
    }

    public static class MyComparator0 implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }
    }

    public static class MyComparator1 implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }

}
