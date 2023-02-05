package algorithm7.leetcode.字符串;

import java.util.*;

/**
 * @Author: permission
 * @Date: 2023/2/5 15:30
 * @Version: 1.0
 * @ClassName: LC49
 * @Description: 49. 字母异位词分组
 */
public class LC49 {

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = groupAnagrams(strs);
        for (List<String> list : lists) {
            for (String s : list) {
                System.out.print(s + "   ");
            }
            System.out.println();
        }
    }


    public static List<List<String>> groupAnagrams(String[] strs) {
//        return handle1(strs);
        return handle2(strs);
    }

    /*
        优化
     */
    private static List<List<String>> handle2(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String key = new String(charArray);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }

    /*
            每个单词转为char数组，按字典序排序（800ms，击败5% - -）
     */
    private static List<List<String>> handle1(String[] strs) {
        int n = strs.length;
        String[] sortedStrs = new String[n];
        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < chars.length; j++) {
                sb.append(chars[j]);
            }
            sortedStrs[i] = sb.toString();
            set.add(sb.toString());

            sb.delete(0, sb.length());
        }
        List<List<String>> res = new ArrayList<>();
        for (String key : set) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < sortedStrs.length; i++) {
                if (key.equals(sortedStrs[i])) {
                    list.add(strs[i]);
                }
            }
            res.add(list);
        }
        return res;
    }

}
