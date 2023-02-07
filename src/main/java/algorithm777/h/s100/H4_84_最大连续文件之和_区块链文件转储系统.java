package algorithm777.h.s100;

import java.util.Scanner;

/**
 * @Author: permission
 * @Date: 2023/2/7 1:18
 * @Version: 1.0
 * @ClassName: H4_84_最大连续文件之和_区块链文件转储系统
 * @Description: 100
 */
public class H4_84_最大连续文件之和_区块链文件转储系统 {

    public static void main(String[] args) {
/*

1000
100 300 500 400 400 150 100
期望输出：950

1000
100 500 400 150 500 100
期望输出：1000
 */
        Scanner scanner = new Scanner(System.in);
        int SATA_MAX = scanner.nextInt();
//        int SATA_MAX = scanner.nextInt();//这里有个坑，nextInt()以\n结束（回车），后面接nextLine()的话，nextLine也会读到\n直接结束，读到一个空串。
//        String s = scanner.nextLine();//换用next的话虽然能读第一个数，但是它不读空格，输入100 500 400 150 500 100只能读到100

        //解决方法，先调一次nextLine()，把回车读掉
        scanner.nextLine();
        String s = scanner.nextLine();

        String[] array = s.split(" ");
        int res = handle(array, SATA_MAX);
        int res2 = handle2(array, SATA_MAX);
        System.out.println(res);
        System.out.println(res2);
    }

    /*
            动态规划解法
     */
    private static int handle(String[] array, int SATA_MAX) {
        int max = 0;
        int pre = 0;
        for (int i = 0; i < array.length; i++) {
            int num = Integer.parseInt(array[i]);
            pre = Math.max(pre + num, pre);
            if (pre > SATA_MAX) {
                pre = 0;
                i--;//把之前加的退回
                continue;
            }
            max = Math.max(pre, max);
        }
        return max;
    }

    /*
            滑动窗口
     */
    private static int handle2(String[] array, int SATA_MAX) {
        int n = array.length;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(array[i]);
        }
        int l = 0;
        int r = 0;
        int max = 0;
        int curSum = 0;
        while (r < n) {
            if (curSum + nums[r] > SATA_MAX) {
                curSum -= nums[l];
                l++;
            } else {
                curSum += nums[r];
                r++;
                max = Math.max(max, curSum);
            }
        }
        return max;
    }
}
