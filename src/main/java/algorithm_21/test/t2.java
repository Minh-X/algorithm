package algorithm_21.test;

/**
 * @Author: permission
 * @Date: 2021/9/10 12:26
 * @Version: 1.0
 * @ClassName: t2
 * @Description: 计算 1-2+3-4+5-6+7„„+n。
 */
public class t2 {
    static int temp;
    static int f1(int n) {
        //保证每次传参的n为正，设为静态避免n过大不断创建变量
        temp = n;
        //递归出口
        if (n==1) {
            return 1;
        }
        if (n%2==0) {
            n = -n;
        }
        return n + f1(temp-1);
    }

    public static void main(String[] args) {
        System.out.println(f1(9999));
    }
}
