package algorithm777.h7.s200;

import java.util.*;

/**
 * @Author: permission
 * @Date: 2023/2/15 22:40
 * @Version: 1.0
 * @ClassName: H21_最大数字
 * @Description: 200
 */
public class H21_最大数字 {

    public static void main(String[] args) {
/*
34533
期望：4533

5445795045
期望：5479504

 */
//        String s = new Scanner(System.in).nextLine();
        StringBuilder sb = new StringBuilder();
//        sb.append("99887766554433221100987654321");
        for (int i = 0; i < 100000; i++) {
            sb.append(new Random().nextInt(10));
        }
        String s = sb.toString();
        long start = System.currentTimeMillis();
        String res = handle(s);
        String res2 = handle2(s);
        long end = System.currentTimeMillis();
        System.out.println(s);
        System.out.println(res);
        System.out.println(res.length());
        System.out.println(res2);
        System.out.println("耗时：" + (end - start) + " ms");
    }

    /*
            有bug
     */
    private static String handle(String s) {
        char[] chars = s.toCharArray();
        ArrayList<Character> charList = new ArrayList<>();
        int n = chars.length;
//        for (int i = 0; i < n; i++) {
//
//        }
        HashMap<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            charList.add(chars[i]);
            List<Integer> cur = map.getOrDefault(chars[i], new ArrayList<>());
            cur.add(i);
            map.put(chars[i], cur);
        }

        for (int k = 0; k < n; k++) {
            List<Integer> curList;
            if (chars[k] != 'N') {
                curList = map.get(chars[k]);
            } else {
                continue;
            }

                for (int i = 0; i < curList.size(); i++) {
                    if (curList.size() > 2) {
                        int curIndex = curList.get(i);
                        if (i >= 2) {//如果前面已经保留有两个，后面的直接删除
                            chars[curIndex] = 'N';
                            curList.remove(i);
                            i--;
                            continue;
                        }
                        if (curIndex + 1 >= n || chars[curIndex] < chars[curIndex + 1]) {//如果chars[curIndex]出现次数大于2，且chars[curIndex]小于chars[curIndex+1]
                            chars[curIndex] = 'N';
                            curList.remove(i);
                            i--;
                        }

                    } else {
                        break;
                    }
                }



        }

//        for (int k = 0; k < n; k++) {
//            List<Integer> list = map.get(chars[k]);
//            int curSize = list.size();
//            for (int i = 0; i < curSize; i++) {
//                if (curSize > 2) {
//                    int curIndex = list.get(i);
//                    if (curIndex + 1 >= list.size() || chars[curIndex] <= chars[curIndex + 1]) {
//                        chars[curIndex] = 'N';
//                        curSize--;
//                    }
//                } else {
//                    break;
//                }
//            }
//        }

        StringBuilder sb = new StringBuilder();
        for (char ch : chars) {
            if (ch != 'N') {
                sb.append(ch);
            }
        }
        return sb.toString();
    }



    /*
            有bug
     */
    public static String handle2(String str) {
        HashMap<Character, Integer> reserve = new HashMap<>();

        // 统计输入字符串中各字符出现的次数
        for (int i = 0; i < str.length(); i++) {
            Character k = str.charAt(i);
            reserve.put(k, reserve.getOrDefault(k, 0) + 1);
        }

        HashSet<Character> full = new HashSet<>();

        char[] arr = str.toCharArray();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            char c = arr[i];

            if (reserve.get(c) <= 2) continue;
            if (i + 1 >= n || c <= arr[i + 1] || full.contains(c)) {
                if (i + 1 < n && c == arr[i + 1] && i + 2 < n && c > arr[i + 2] && !full.contains(c)) {
                    full.add(c);
                    i++;
                    continue;
                }
                arr[i] = ' ';
                reserve.put(c, reserve.get(c) - 1);
            }
        }

        String ans = new String(arr);
        return ans.replaceAll(" ", "");
    }
}

