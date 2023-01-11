package algorithm_21.位运算;

import algorithm.util.MyUtil;

import java.util.Random;

/**
 * 找出数组中唯一成对的数
 * @author permission
 * @Date 2021 - 06 - 07 - 10:22
 * @package PACKAGE_NAME
 * @Description: 唯一成对的数
 */


public class 唯一成对的数 {
    public static void main(String[] args) {
        /*
            题目描述：
            1-1000这1000个数放在含有1001个元素的数组中，只有唯一一个元素值重复，其他均只出现一次。
            每个数组元素只能访问一次，设计一个算法，将它找出来；不用辅助空间，能否设计一个算法实现？

            思路：任何数和0异或得本身，相同数异或得0
            可以将 0-1000 与数组所有元素进行异或（数组中存有0-1000加一个重复的数，0-1000与0-1000异或得到0，0再与重复的数进行异或得到结果）
         */
        int N = 1001;
        int[] arr = new int[N];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i+1;
        }
        //生成随机数 1 - (N-1) 放在最后一位
        arr[arr.length-1] = new Random().nextInt(N-2)+1;
        MyUtil.printArr(arr);
        System.out.println();
        System.out.println("重复的数是（期望结果）：" + arr[arr.length-1]);
        //生成随机数 1 - (N-1)   将生成的随机数从最后一位放入数组中随机位置
        int index = new Random().nextInt(N-2)+1;
        MyUtil.swap(arr,index,arr.length-1);

        //任何数和0异或得本身
        int result = 0;
        // arr[0] - arr[N-1] 进行异或
        for (int i = 0; i < N; i++) {
            result = result ^ arr[i];
        }
        //arr[0] - arr[N-1] 进行异或的结果与 1 - (N-1) 进行异或
        for (int i = 1; i < N; i++) {
            result = result ^ i;
        }
        System.out.println("异或方法查找结果为（不借助辅助空间）：" + result);

        //暴力解法，借助辅助空间
        int[] helper = new int[N];
        for (int i = 0; i < N; i++) {
            helper[arr[i]]++;
        }
        //结果为数组元素 =2 的下标
        for (int i = 0; i < N; i++) {
            if (helper[i] == 2){
                System.out.println("暴力法查找结果为（借助辅助空间）：" + i);
            }
        }
    }
}
