package algorithm7.leetcode.字符串;

/**
 * @Author: permission
 * @Date: 2023/1/14 17:02
 * @Version: 1.0
 * @ClassName: LC13
 * @Description: 13. 罗马数字转整数
 */
public class LC13 {

    public int romanToInt(String s) {
        int res = 0;
        s = s.replace("IV", "a");//4
        s = s.replace("IX", "b");//9
        s = s.replace("XL", "c");//40
        s = s.replace("XC", "d");//90
        s = s.replace("CD", "e");//400
        s = s.replace("CM", "f");//900

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            res += getValue(ch);
        }

        return res;
    }

    private int getValue(char ch) {
        switch (ch) {
            case 'I' : return 1;
            case 'V' : return 5;
            case 'X' : return 10;
            case 'L' : return 50;
            case 'C' : return 100;
            case 'D' : return 500;
            case 'M' : return 1000;
            case 'a' : return 4;
            case 'b' : return 9;
            case 'c' : return 40;
            case 'd' : return 90;
            case 'e' : return 400;
            case 'f' : return 900;
        }
        return 0;
    }

}
