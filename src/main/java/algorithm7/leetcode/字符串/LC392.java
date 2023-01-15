package algorithm7.leetcode.字符串;

/**
 * @Author: permission
 * @Date: 2023/1/15 21:58
 * @Version: 1.0
 * @ClassName: LC392
 * @Description: 392. 判断子序列
 */
public class LC392 {

    /*
            如果s是t的子序列，也就是说s中的所有字符都会按照顺序出现在t中，因此，使用双指针的方式实现:
     */
    public boolean isSubsequence(String s, String t) {
        char[] s1 = s.toCharArray();
        char[] s2 = t.toCharArray();

        int i = 0;
        int j = 0;
        while (i < s1.length && j < s2.length) {
            if (s1[i] == s2[j]) {
                i++;
                j++;
            } else {
                j++;
            }
        }
        return i == s1.length;
    }


}
