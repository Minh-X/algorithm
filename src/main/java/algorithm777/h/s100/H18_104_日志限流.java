package algorithm777.h.s100;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: permission
 * @Date: 2023/2/10 22:39
 * @Version: 1.0
 * @ClassName: H18_104_日志限流
 * @Description: 100
 */
public class H18_104_日志限流 {

    public static void main(String[] args) {
/*
6
3 3 8 7 10 15
40
期望输出：
9
 */
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();//系统运行单位时间n
        int[] records = new int[n];//第i单位时间内产生的日志条数
        for (int i = 0; i < n; i++) {
            records[i] = scanner.nextInt();
        }
        int total = scanner.nextInt();//每天可保存的日志总数
        int res = handle(records, n, total);
        System.out.println(res);
    }

    //二分查找，每次取min_limit和max_limit的中间
    private static int handle(int[] records, int n, int total) {
        int sum = Arrays.stream(records).sum();
        if (sum <= total) {
            return -1;
        }
        int min_limit = total / n;//单位时间最小limit
        int max_limit = Arrays.stream(records).max().getAsInt();
        int res_limit = binary_Search(min_limit, max_limit, records, total);
        return res_limit;
    }

    private static int binary_Search(int min_limit, int max_limit, int[] records, int total) {
        int ans = min_limit;
        while (max_limit - min_limit > 1) {
            int mid = (min_limit + max_limit) / 2;
            int tmp = 0;
            for (int record : records) {
                tmp += Math.min(record, mid);
            }
            if (tmp > total) {//mid大了
                max_limit = mid;
            } else if (tmp < total) {
                min_limit = mid;
                ans = mid;//如果找不到刚好限流的大小，找能满足的最大的限流
            } else {
                return mid;
            }
        }
        return ans;
    }
}
