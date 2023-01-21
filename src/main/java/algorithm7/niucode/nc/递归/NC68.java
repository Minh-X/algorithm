package algorithm7.niucode.nc.递归;

/**
 * @Author: permission
 * @Date: 2023/1/21 14:49
 * @Version: 1.0
 * @ClassName: NC68
 * @Description: NC68 跳台阶
 */
public class NC68 {

    public int jumpFloor(int target) {
        int[] f = new int[40];
        return handle3(target);
    }

    /*
        动态规划：从下往上
     */
    private int handle3(int target) {
        int[] dp = new int[40];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= target; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[target];
    }


    /*
        递归：从上往下，找到最下层答案再回溯
    */
    // 记忆化递归
    private int handle2(int target, int[] f) {
        if (target <= 1) {
            return 1;
        }
        if (f[target] > 0) {
            return f[target];
        }
        return handle2(target - 1, f) + handle2(target - 2, f);
    }
    // 递归，超时
    private int handle(int target) {
        if (target == 1) {
            return 1;
        }
        return handle(target - 1) + handle(target - 2); //表示从n-1到n阶有2种跳法
    }

}
