package algorithm7.leetcode.每日一题;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: permission
 * @Date: 2023/2/9 2:31
 * @Version: 1.0
 * @ClassName: LC1797_20230209
 * @Description: 1797. 设计一个验证系统
 */
public class LC1797_20230209 {

    public static void main(String[] args) {
        AuthenticationManager authenticationManager = new AuthenticationManager(1);
    }


    static class AuthenticationManager {
        private int timeToLive;
        Map<String, Integer> map;

        public AuthenticationManager(int timeToLive) {
            this.timeToLive = timeToLive;
            map = new HashMap<>();
        }

        public void generate(String tokenId, int currentTime) {
            map.put(tokenId, currentTime + timeToLive);
        }

        public void renew(String tokenId, int currentTime) {
            if (map.getOrDefault(tokenId, 0) > currentTime) {
                map.put(tokenId, currentTime + timeToLive);
            }
        }

        public int countUnexpiredTokens(int currentTime) {
            int res = 0;
            for (Integer value : map.values()) {
                if (value > currentTime) {
                    res++;
                }
            }
            return res;
        }
    }

}
