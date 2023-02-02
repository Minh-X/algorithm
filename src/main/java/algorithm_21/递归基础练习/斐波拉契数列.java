package algorithm_21.递归基础练习;

/**
 * 斐波拉契数列
 *
 * @author permission
 * @Date 2021 - 07 - 11 - 15:09
 * @package algorithm.递归基础练习
 * @Description: 1 1 2 3 5 8 13
 */
public class 斐波拉契数列 {
    public int a1(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return a1(n - 1) + a1(n - 2);
    }

    public static void main(String[] args) {
        斐波拉契数列 obj = new 斐波拉契数列();
        int result = obj.a1(7);
        System.out.println(result);
    }
}
