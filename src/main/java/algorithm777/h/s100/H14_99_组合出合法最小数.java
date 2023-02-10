package algorithm777.h.s100;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: permission
 * @Date: 2023/2/10 14:47
 * @Version: 1.0
 * @ClassName: H14_99_组合出合法最小数
 * @Description: 100
 */
public class H14_99_组合出合法最小数 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] strs = sc.nextLine().split(" ");
        System.out.println(getResult(strs));
    }

    /*
            (此题数组大小1-50，如果用全排列O(50!) 会超时)
            按照两两组合后的字典序小的排序（贪心）
            排序后直接拼接所有即为答案（此题有前导0，需要进行处理）
     */
    public static String getResult(String[] strs) {
        Arrays.sort(strs, (a, b) -> (a + b).compareTo(b + a));

        //处理前导0，找到第一个没有前导0的字符进行拼接，放到0号位，当前位置置为""，再拼接所有即可
        if (strs[0].charAt(0) == '0') {
            for (int i = 1; i < strs.length; i++) {
                if (strs[i].charAt(0) != '0') {
                    strs[0] = strs[i] + strs[0];
                    strs[i] = "";
                    break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str);
        }

        //^0+   ^字符串开头， +一次或多次（如果输入的字符都是0开头，组合后去除前面的0）
        return sb.toString().replaceAll("^0+", "");
    }

}
