package algorithm_21.test;

/**
 * @Author: permission
 * @Date: 2021/9/10 12:21
 * @Version: 1.0
 * @ClassName: t1
 * @Description: 1-100累加
 */
public class t1 {
    static int f1(int n) {
        if (n==1) {
            return 1;
        }
        return n + f1(n-1);
    }

    public static void main(String[] args) {
        System.out.println(f1(100));
    }
}
