package algorithm7.leetcode.动态规划;

/**
 * @Author: permission
 * @Date: 2023/1/31 21:48
 * @Version: 1.0
 * @ClassName: LC1143
 * @Description: 1143. 最长公共子序列
 */
public class LC1143 {

    public static void main(String[] args) {
        //"nwlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarc"
        //"bynecdyggxxpklorellnmpapqfwkhopkmcoqhnwnkuewhsqmgb"
        //预期：14
        String s1 = "nwlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarc";
        String s2 = "bynecdyggxxpklorellnmpapqfwkhopkmcoqhnwnkuewhsqmgb";

//        String s1 = "a12x";
//        String s2 = "1c2";
        long start = System.currentTimeMillis();
        System.out.println(longestCommonSubsequence(s1, s2));
        long end = System.currentTimeMillis();
        System.out.println("耗时：" + (start - end) + "ms");
    }


    public static int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text2 == null || text1.length() == 0 || text2.length() == 0) {
            return 0;
        }
        char[] str1 = text1.toCharArray();
        char[] str2 = text2.toCharArray();
        return handle_recursion(str1, str2, str1.length - 1, str2.length - 1);
    }

    /*
            暴力递归（超时）
     */
    //返回str1[0...i]位置和str2[0...j]位置的最长公共子序列长度
    private static int handle_recursion(char[] charArray1, char[] charArray2, int i, int j) {
        if (i == 0 && j == 0) {
            //只有1个字符
            return charArray1[i] == charArray2[j] ? 1 : 0;
        } else if (i == 0) {
            //str1到最后一个字符
            if (charArray1[i] == charArray2[j]) {
                //相同返回1
                return 1;
            } else {
                //不相同求str1[0...0]和str2[0...j-1]位置的最长公共子序列
                return handle_recursion(charArray1, charArray2, 0, j - 1);
            }
        } else if (j == 0) {
            //str2到最后一个字符
            if (charArray1[i] == charArray2[j]) {
                return 1;
            } else {
                //不相同求str2[0...0]和str1[0...i-1]位置的最长公共子序列
                return handle_recursion(charArray1, charArray2, i - 1, 0);
            }
        } else {
            //i和j都不为0（都没到最后一个字符）
//            int p7 = handle_recursion(charArray1, charArray2, i - 1, j - 1);//不考虑str1[i]、str2[j]
            int p1 = handle_recursion(charArray1, charArray2, i - 1, j);//不考虑str1[i]
            int p2 = handle_recursion(charArray1, charArray2, i, j - 1);//不考虑str2[j]
            int p3 = 0;//str1[i]和str2[j]一样（以 i、j 结尾），长度 + 1
            if (charArray1[i] == charArray2[j]) {
                p3 = 1 + handle_recursion(charArray1, charArray2, i - 1, j - 1);
            }
            return Math.max(p1, Math.max(p2, p3));
        }
    }

}
