package algorithm7.leetcode.每日一题;

import java.util.Map;
import java.util.TreeMap;

/**
 * @Author: permission
 * @Date: 2023/2/1 2:00
 * @Version: 1.0
 * @ClassName: LC2325_20230201
 * @Description: 2325. 解密消息
 */
public class LC2325_20230201 {

    public static void main(String[] args) {
        decodeMessage("the quick brown fox jumps over the lazy dog", "vkbs bs t suepuv");
    }

    public static String decodeMessage(String key, String message) {
        key = key.trim();
        key = key.replaceAll(" ", "");
        char[] keyArray = key.toCharArray();
        char[] messageArray = message.toCharArray();
        Map<Character, Character> map = new TreeMap<>();
        char j = 'a';
        for (int i = 0; i < keyArray.length; i++) {
            if (!map.containsKey(keyArray[i])) {
                map.put(keyArray[i], j);
                j++;
            }
        }
        StringBuilder sb = new StringBuilder(messageArray.length);
        for (int i = 0; i < messageArray.length; i++) {
            if (messageArray[i] != ' ') {
                sb.append(map.get(messageArray[i]));
            } else {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

}
