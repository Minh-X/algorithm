package algorithm7.leetcode.随机;

/**
 * @Author: permission
 * @Date: 2023/1/31 23:09
 * @Version: 1.0
 * @ClassName: 递归乘法
 * @Description: 面试题 08.05. 递归乘法
 */
public class 递归乘法 {

    public static void main(String[] args) {
        System.out.println(multiply(918795921, 2));
    }

    public static int multiply(int A, int B) {
        // return A > B ? multiplyB(A, B) : multiplyA(A, B);
        if (A == 0 || B == 0) {
            return 0;
        }
        if (A < B) {
            return B + multiply(A - 1, B);
        }
        return A + multiply(A, B - 1);
    }

    // public int multiplyA(int A, int B) {
    // if(A == 0) return 0;
    //     return B + multiply(A - 1, B);
    // }
    // public int multiplyB(int A, int B) {
    //     if(B == 0) return 0;
    //     return A + multiply(A, B-1);
    // }

}
