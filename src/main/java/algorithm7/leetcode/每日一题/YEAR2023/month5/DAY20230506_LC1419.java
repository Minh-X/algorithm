package algorithm7.leetcode.每日一题.YEAR2023.month5;

import org.junit.jupiter.api.Test;

public class DAY20230506_LC1419 {


    int minNumberOfFrogs(String croakOfFrogs) {
        return handle1(croakOfFrogs);
    }

    private int handle1(String croakOfFrogs) {
        if (croakOfFrogs.length() % 5 != 0) {
            return -1;
        }
        int c = 0;
        int r = 0;
        int o = 0;
        int a = 0;
        int k = 0;
        int minFrogNum = 0;
        int frog = 0;
        for (int i = 0; i < croakOfFrogs.length(); i++) {
            char ch = croakOfFrogs.charAt(i);
            if (ch == 'c') {
                c++;
                frog++;
                minFrogNum = Math.max(minFrogNum, frog);
            } else if (ch == 'r') {
                r++;
                if (r > c) {
                    return -1;
                }
            } else if (ch == 'o') {
                o++;
                if (o > r) {
                    return -1;
                }
            } else if (ch == 'a') {
                a++;
                if (a > o) {
                    return -1;
                }
            } else if (ch == 'k') {
                if (k > a) {
                    return -1;
                }
                k++;
                frog--;
            }
        }
        return (c == r && c == o && c == a && c == k) ? minFrogNum : -1;
    }


    @Test
    void t1() {
        String croakOfFrogs = "croakcroa";
        long start = System.nanoTime();
        int res = minNumberOfFrogs(croakOfFrogs);
        long end = System.nanoTime();
        System.out.println("res = " + res);
        System.out.println("(end - start) = " + (end - start) + " ns");
    }

}
