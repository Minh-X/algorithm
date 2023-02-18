package algorithm7.leetcode.每日一题.YEAR2023.MONTH2;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: permission
 * @Date: 2023/2/18 15:50
 * @Version: 1.0
 * @ClassName: DAY20230218_LC1237
 * @Description: 1237. 找出给定方程的正整数解
 */
public class DAY20230218_LC1237 {

    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
//        return handle_recursion(customfunction,z);
        return handle_doublePoint(customfunction, z);
    }

    /*
            双指针
     */
    private List<List<Integer>> handle_doublePoint(CustomFunction customfunction, int z) {
        return null;
    }

    /*
            暴力
     */
    private List<List<Integer>> handle_recursion(CustomFunction customfunction, int z) {
        List<List<Integer>> res = new ArrayList<>();
        for (int x = 1; x <= 1000; x++) {
            for (int y = 1; y <= 1000; y++) {
                if (customfunction.f(x, y) == z) {
                    ArrayList<Integer> cur = new ArrayList<>();
                    cur.add(x);
                    cur.add(y);
                    res.add(cur);
                }
            }
        }
        return res;
    }


    // This is the custom function interface.
    // You should not implement it, or speculate about its implementation
    class CustomFunction {
        // Returns f(x, y) for any given positive integers x and y.
        // Note that f(x, y) is increasing with respect to both x and y.
        // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
        public int f(int x, int y) {
            return x + y;
        }
    }

    ;

}
