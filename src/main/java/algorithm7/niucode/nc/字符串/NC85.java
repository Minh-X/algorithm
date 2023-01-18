package algorithm7.niucode.nc.字符串;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: permission
 * @Date: 2023/1/18 17:47
 * @Version: 1.0
 * @ClassName: NC85
 * @Description: NC85 拼接所有的字符串产生字典序最小的字符串 （贪心）
 */
public class NC85 {

    public static void main(String[] args) {
        String[] strings = new String[3];
        strings[0] = "aa";
        strings[1] = "bb";
        strings[2] = "cc";
        minString(strings);
    }

    public static String minString (String[] strs) {
        // write code here
        return handle(strs);
    }

    private static String handle(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        Arrays.sort(strs, new MyComparator());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
            sb.append(strs[i]);
        }
        return sb.toString();
    }

    public static class MyComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            return (o1 + o2).compareTo(o2 + o1);
        }
    }
}
