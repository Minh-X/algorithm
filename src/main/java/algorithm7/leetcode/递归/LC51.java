package algorithm7.leetcode.递归;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @Author: permission
 * @Date: 2023/2/3 1:11
 * @Version: 1.0
 * @ClassName: LC51
 * @Description: 51. N 皇后
 */
public class LC51 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        while (true) {
        int n = scanner.nextInt();
        List<List<String>> res = solveNQueens(n);
        for (List<String> r : res) {
            for (String s : r) {
                System.out.print(s+"   ");
            }
            System.out.println();
//            }
        }
    }

    /*
        返回放的位置
     */
    public static List<List<String>> solveNQueens(int n) {
        int[] record = new int[n];
        List<List<String>> res = new ArrayList<>();
        ArrayList<String> s = new ArrayList<>();
        handle(0, n, record, res, s);
        return res;
    }

    private static void handle(int i, int n, int[] record, List<List<String>> res, ArrayList<String> s) {
        if (i == n) {
            for (int j = 0; j < n; j++) {//一种解法，n层皇后摆放的位置
                char[] row = new char[n];
                Arrays.fill(row, '.');
                row[record[j]] = 'Q';
                s.add(new String(row));
            }
            ArrayList<String> s1 = (ArrayList<String>) s.clone();//复制一个新的list，res.add是将list地址放进去，不复制的话下面s.clear会将放进res的解法清空（add加入的是地址）
            res.add(s1);//当前解法加到res
            s.clear();//清空当前解法
            return;
        }
        for (int j = 0; j < n; j++) {
            if (isValid(i, j, record)) {
                record[i] = j;
                handle(i + 1, n, record, res, s);
            }
        }
    }

    private static boolean isValid(int i, int j, int[] record) {
        for (int k = 0; k < i; k++) {//判断现在要放的位置和前i行已经放好的是否冲突
            if (j == record[k] || Math.abs(j - record[k]) == Math.abs(i - k)) {
                return false;
            }
        }
        return true;
    }
}
