package algorithm7.leetcode.字符串;

/**
 * @Author: permission
 * @Date: 2023/1/14 17:20
 * @Version: 1.0
 * @ClassName: LC14
 * @Description: 14. 最长公共前缀
 */
public class LC14 {

    /*
            输入：strs = ["flower","flow","flight"]
            输出："fl"

            输入：
                ["reflower","flow","flight"]
            预期结果：
                ""
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        int minStrLen = strs[0].length();
        int minStrIndex = 0;
        for (int i = 1; i < strs.length; i++) {
            if (strs[i].length() < minStrLen) {
                minStrLen = strs[i].length();
                minStrIndex = i;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < minStrLen; i++) {
            char temp = strs[minStrIndex].charAt(i);
            for (int j = 0; j < strs.length; j++) {
                if (strs[j].charAt(i) != temp) {
                    temp = strs[j].charAt(i);
                    break;
                }
            }
            if (temp == strs[minStrIndex].charAt(i)) {
                sb.append(temp);
            } else {
                break;
            }
        }
        return sb.toString();
    }

    public String longestCommonPrefix2(String[] strs) {
        if(strs.length==0)return "";
        //公共前缀比所有字符串都短，随便选一个先
        String s=strs[0];
        for (String string : strs) {
            while(!string.startsWith(s)){
                if(s.length()==0)return "";
                //公共前缀不匹配就让它变短！
                s=s.substring(0,s.length()-1);
            }
        }
        return s;
    }
}
