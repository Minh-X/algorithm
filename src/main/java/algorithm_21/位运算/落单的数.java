package algorithm_21.位运算;

import algorithm_21.util.MyUtil;

import java.util.Random;

/**
 * 题目描述：
 * 一个数组里除了某一个数字之外，其他的数字都出现了两次。
 * 请写出程序找出这个只出现一次的数字
 * @author permission
 * @Date 2021 - 06 - 08 - 9:51
 * @package algorithm.位运算
 * @Description: 找出落单的数
 *
 */

public class 落单的数 {
    /**
     * 生成数组
     * @return 数组
     */
    public int[] creatArr(){
        int N = 1001;
        int[] arr = new int[N];
        for (int i = 0, j = 1; i < N-1; i=i+2) {
            arr[i] = j;
            arr[i + 1] = j;
            j++;
        }
        //生成随机数 1 - (N-1) 放在最后一位
        arr[arr.length-1] = new Random().nextInt(N/2-2)+1;
        int expectation = arr[arr.length-1];
        //生成随机数 1 - (N-1)   将生成的随机数从最后一位放入数组中随机位置
        int index = new Random().nextInt(N-2)+1;
        MyUtil.swap(arr,index,arr.length-1);
        MyUtil.printArr(arr);
        System.out.println("落单的数是（期望结果）：" + expectation);
        return arr;
    }

    /**
     * 题解：
     * 两个相同的数异或得0，任何数与0异或得本身，故将数组中每个数异或即可得到结果
     */
    public void findSingle(){
        int[] arr = creatArr();
        int result = arr[0];
        for (int i = 1; i < arr.length; i++) {
            result = arr[i] ^ result;
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        new 落单的数().findSingle();
    }
}
