package algorithm_21.位运算;

import java.util.Scanner;

/**
 * 二进制表示0到1的浮点实数
 * 给定一个介于0到1的实数，类型为double，打印它的二进制表示
 * 如果该数字无法精确地用32位以内的二进制表示，则打印“ERROR”
 * 例：输入0.625 输出0.101
 *
 * @author permission
 * @Date 2021 - 06 - 09 - 15:08
 * @package algorithm.位运算
 * @Description:
 */
public class 二进制表示0到1的浮点实数 {
    /**
     * 题解：
     * 乘以2，取走高位
     * @param d
     */
    public void judge(Double d){
        StringBuffer sb = new StringBuffer("0.");
        while (d>0&&sb.length()<34){
            d *= 2;
            if (d>=1){
                sb.append("1");
                d -= 1;
            } else {
                sb.append("0");
            }
        }
        if (sb.length()<34){
            System.out.println(sb);
        } else {
            System.out.println("ERROR");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("输入一个0到1的浮点数：");
        double aDouble = scanner.nextDouble();
        new 二进制表示0到1的浮点实数().judge(aDouble);
    }
}
