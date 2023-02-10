package algorithm777.h7.s200;

import java.util.Scanner;

/**
 * @Author: permission
 * @Date: 2023/2/8 18:17
 * @Version: 1.0
 * @ClassName: H14_200_2023Q1_二进制差异数
 * @Description: 200
 */
public class H2023Q1_200_14_二进制差异数 {

    public static void main(String[] args) {
/*
4
4 3 5 2
期望：4
说明：(0,1),(0,3),(1,2),(2,3)

4
10 12 10 6
期望：3
*/

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
//            nums[i] = i+1;
        }

        long start = System.currentTimeMillis();
        handle2(nums, n);
        handle1(nums, n);
        long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - start) / 1000 + "s");
    }

    /*
           (10) 1010                                  (10)  1010
           (12) 1100 最高位相同，异或必然小于与运算，不符合   (6)  0110 最高位不同，异或大于与运算，符合要求
            将所有数转为二进制，统计最高位为1的位置i（转为二进制的len，jdk高位不为0）的个数，所有最高位位置不同的相乘再相加即为答案
            例如上面：10，12，10，6  转换后最高位为3的有3个，最高号为为2的有1个，答案即为3
     */
    private static void handle2(int[] nums, int n) {
        long res = 0;

        int[] highBit = new int[30];//题中给的A[i]最大值为2^30，highBit[i]表示nums数组中的数的最高位是i且等于1的个数
        for (int num : nums) {
            String binary = Integer.toBinaryString(num);
            int len = binary.length();

//            if ("0".equals(binary)) {//数据范围大于0，不用处理0
//                highBit[0]++;
//            } else {
            highBit[len]++;
//            }
        }

        for (int i = 1; i < highBit.length; i++) {
            for (int j = i + 1; j < highBit.length; j++) {
                res += highBit[i] * highBit[j];
            }
        }
        System.out.println(res);
    }

    /*
        暴力
        题中n最大为 10^5，暴力算法O(n^2)会超时，
        对于n为10^5的题，时间复杂度应该控制在O(n)
     */
    private static void handle1(int[] nums, int n) {
        long res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int and = nums[i] & nums[j];
                int xor = nums[i] ^ nums[j];
                if (xor > and) {
                    res++;
//                    System.out.print(i + " " + j + "   ");
                }
            }
//            System.out.println();
        }
        System.out.println(res);
    }

}