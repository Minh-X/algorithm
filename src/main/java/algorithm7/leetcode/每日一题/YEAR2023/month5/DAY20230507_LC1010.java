package algorithm7.leetcode.每日一题.YEAR2023.month5;


import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Author: permission
 * @Date: 2023/5/7 2:20
 * @Version: 1.0
 * @ClassName: DAY20230507_LC1010
 * @Description: 总持续时间可被 60 整除的歌曲
 * 在歌曲列表中，第 i 首歌曲的持续时间为 time[i] 秒。
 * <p>
 * 返回其总持续时间（以秒为单位）可被 60 整除的歌曲对的数量。形式上，我们希望下标数字 i 和 j 满足 i < j 且有(time[i] + time[j]) % 60 == 0。
 * <p>
 * <p>
 * 示例 1：
 * 输入：time = [30,20,150,100,40]
 * 输出：3
 * 解释：这三对的总持续时间可被 60 整除：
 * (time[0] = 30, time[2] = 150): 总持续时间 180
 * (time[1] = 20, time[3] = 100): 总持续时间 120
 * (time[1] = 20, time[4] = 40): 总持续时间 60
 * <p>
 * 示例 2：
 * 输入：time = [60,60,60]
 * 输出：3
 * 解释：所有三对的总持续时间都是 120，可以被 60 整除。
 */
public class DAY20230507_LC1010 {

    public int numPairsDivisibleBy60(int[] time) {
//        return handle1(time);
//        return handle2(time);
        return handle3(time);
    }

    /*
        handle2 优化
     */
    private int handle3(int[] time) {
        int len = time.length;
        int[] cnt = new int[len];
        for (int item : time) {
            cnt[item % 60]++;
        }
        // int会超出
        long res = 0;
        // 1 - 29
        for (int i = 1; i < 30; i++) {
            res += cnt[i] * cnt[60 - i];
        }
        // 再加上30和0
        res += cnt[0] * (cnt[0] -1) / 2;
        res += cnt[30] * (cnt[30] -1) / 2;
        return (int) res;
    }

    /*
            每个数对60取余，放入hash表
            例如：20 和 100：
                    20%60 = 20，此时 map(20) = 1;
                    100%60 = 40，此时 map(40) = 1;
                    此时组合数就是 map(20) * map(40) = 1*1 = 1
                特殊情况，30,60,0(题中给出time[i] >= 1)，所以只用考虑30,60（handle2方法中考虑了0，写的时候没注意边界，不想改了）
                这种情况下组合数为 map(30) * (map(30) - 1) / 2，
                        也就是 n * (n - 1) / 2
     */
    private int handle2(int[] time) {
        Map<Integer, Long> map = new HashMap<>(16);
        long res = 0;
        for (int i = 0; i < time.length; i++) {
            int key = time[i] % 60;
            map.put(key, map.getOrDefault(key, 0L) + 1);
        }
        Set<Integer> keySet = map.keySet();
        // 这里计算了两遍-_- 屎山无疑了
        for (Integer key : keySet) {
            if (key.equals(30)) {
                res += (map.get(key) * (map.get(key) - 1));
                continue;
            }
            if (key.equals(0) || key.equals(60)) {
                res += (map.get(key) * (map.get(key) - 1));
                continue;
            }
            res += (map.get(key) * map.getOrDefault(60 - key, 0L));
        }
        return (int) (res / 2);
    }

    /*
            1 <= time.length <= 6 * 104
            1 <= time[i] <= 500
            此暴力解法会超时
     */
    private int handle1(int[] time) {
        int length = time.length;
        int res = 0;

        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                if ((time[i] + time[j]) % 60 == 0) {
                    res++;
                }
            }
        }

        return res;
    }

    @Test
    void t() {
        int[] time = {309, 148, 402, 199, 180, 170, 293, 72, 165, 318, 178, 444, 105, 265, 311, 223, 242, 11, 341, 232, 37, 90, 214, 73, 15, 431, 82, 323, 291, 296, 234, 32, 21, 156, 235, 379, 275, 273, 69, 91, 275, 93, 281, 212, 478, 365, 126, 457, 268, 85, 217, 144, 325, 376, 357, 457, 129, 189, 140, 384, 21, 342, 416, 34, 252, 216, 311, 228, 380, 149, 123, 276, 458, 225, 271, 489, 125, 377, 440, 459, 428, 52, 372, 337, 55, 1, 183, 214, 42, 174, 193, 196, 230, 144, 213, 292, 34, 8, 61, 432, 23, 24, 128, 416, 136, 196, 290, 406, 103, 394, 408, 97, 222, 418, 122, 94, 171, 214, 418, 458, 141, 356, 212, 217, 428, 183, 488, 471, 29, 441, 190, 133, 152, 448, 390, 40, 180, 28, 156, 43, 299, 251, 250, 48, 423, 437, 417, 303, 81, 284, 448, 459, 30, 273, 141, 111, 61, 366, 157, 434, 155, 114, 208, 423, 56, 8, 95, 461, 351, 448, 244, 244, 121, 112, 374, 267, 26, 176, 203, 24, 142, 98, 372, 208, 438, 335, 432, 456, 161, 157, 353, 161, 235, 395, 389, 208};
        long start = System.currentTimeMillis();
        int res = numPairsDivisibleBy60(time);
        long end = System.currentTimeMillis();
        System.out.println("res = " + res);
        System.out.println("(end - start) = " + (end - start));
    }

}