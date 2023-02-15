package algorithm777.h7.s200;

import java.util.*;

/**
 * @Author: permission
 * @Date: 2023/2/14 21:47
 * @Version: 1.0
 * @ClassName: H19_最差产品奖
 * @Description: 200
 */
public class H19_最差产品奖 {

    public static void main(String[] args) {
/*
3
12,3,8,6,5
12 3 8 6 5 1 99 3
期望输出：3 3 5


3
12,3,8,6,5,1,99,3
 */
        Scanner scanner = new Scanner(System.in);
        int M = scanner.nextInt();//区间
        scanner.nextLine();
        Integer[] infos = Arrays.stream(scanner.nextLine().split(",")).map(Integer::parseInt).toArray(Integer[]::new);
        List<Integer> res = handle(infos, M);
        for (Integer r : res) {
            System.out.print(r + " ");
        }
    }

    /*
            滑动窗口
     */
    private static List<Integer> handle(Integer[] infos, int m) {
        int n = infos.length;
        List<Integer> res = new ArrayList<>();

        Deque<Integer> slideWindow = new LinkedList<>();
        int r = 0;
        int l = r - m + 1;
        while (r < n) {
            while (!slideWindow.isEmpty() && infos[slideWindow.peekLast()] >= infos[r]) {
                slideWindow.pollLast();
            }
            slideWindow.offerLast(r);

            if (!slideWindow.isEmpty() && l >= 0) {
                res.add(infos[slideWindow.peekFirst()]);
            }
            r++;
            l++;

            while (!slideWindow.isEmpty() && slideWindow.peekFirst() < l) {
                slideWindow.pollFirst();
            }
        }
        return res;
    }

}
