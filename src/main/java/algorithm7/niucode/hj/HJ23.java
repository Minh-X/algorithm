package algorithm7.niucode.hj;

import java.util.*;

/**
 * @Author: permission
 * @Date: 2023/1/21 18:19
 * @Version: 1.0
 * @ClassName: HJ23
 * @Description: HJ23 删除字符串中出现次数最少的字符
 *                  数据范围：输入的字符串长度满足1≤n≤20  ，保证输入的字符串中仅出现小写字母
 *                          字符串只包含小写英文字母, 不考虑非法输入
 */
public class HJ23 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) {
            String str = in.next();
            deleteLeast2(str);
        }
    }

    /*
            字符串中只有小写，使用int[26]，表示每个字母出现的次数
     */
    private static void deleteLeast2(String str) {
        char[] charArray = str.toCharArray();
        int[] charNum = new int[26];
        int index;
        for (int i = 0; i < charArray.length; i++) {
            index = charArray[i] - 'a';
            charNum[index]++;
        }

        int minValue = Integer.MAX_VALUE;
        for (int i = 0; i < charNum.length; i++) {
            if (charNum[i] < minValue && charNum[i] != 0) {
                minValue = charNum[i];
            }
        }
        List<Character> minCharList = new ArrayList<>();
        for (int i = 0; i < charNum.length; i++) {
            if (charNum[i] == minValue) {
                minCharList.add(Character.valueOf( (char) (i+'a')));
            }
        }
        for (int i = 0; i < minCharList.size(); i++) {
            str = str.replaceAll(String.valueOf(minCharList.get(i)), "");
        }
        System.out.println(str);
    }


    private static void deleteLeast(String str) {
        char[] charArray = str.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < charArray.length; i++) {
            if (!map.containsKey(charArray[i])) {
                map.put(charArray[i], 1);
            } else {
                map.put(charArray[i], map.get(charArray[i]) + 1);
            }
        }
        Optional<Map.Entry<Character, Integer>> min = map.entrySet().stream().min(Comparator.comparingInt(Map.Entry::getValue));
        Map.Entry<Character, Integer> minEntry = min.get();
        Character minKey = minEntry.getKey();
        Integer minValue = minEntry.getValue();
        map.remove(minKey, minValue);
        str = str.replaceAll(String.valueOf(minKey), "");
        min = map.entrySet().stream().min(Comparator.comparingInt(Map.Entry::getValue));
        while (min.get().getValue() == minValue) {
            minEntry = min.get();
            minKey = minEntry.getKey();
            minValue = minEntry.getValue();
            map.remove(minKey, minValue);

            str = str.replaceAll(String.valueOf(minKey), "");
            min = map.entrySet().stream().min(Comparator.comparingInt(Map.Entry::getValue));
        }
        System.out.println(str);
    }
}
