package algorithm7.niucode.nc.递归;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

/**
 * @Author: permission
 * @Date: 2023/1/29 18:04
 * @Version: 1.0
 * @ClassName: NC43
 * @Description: NC43 没有重复项数字的全排列
 */
public class NC43 {

    public static void main(String[] args) {
        int[] ccc = {1, 1, 2};
        ArrayList<ArrayList<Integer>> res = permute(ccc);
        for (ArrayList<Integer> re : res) {
            for (Object o : re.toArray()) {
                System.out.print(o.toString() + " ");
            }
            System.out.println();
        }
    }

    public static ArrayList<ArrayList<Integer>> permute(int[] num) {
        HashSet<ArrayList<Integer>> res = new HashSet<>();
        ArrayList<Integer> nums = new ArrayList<>();
        for (int item : num) {
            nums.add(item);
        }
        handle_recursion2(nums, 0, res);
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (ArrayList<Integer> re : res) {
            list.add(re);
        }
        list.sort((o1, o2) -> {
            for (int i = 0; i < o1.size(); i++) {
                if (o1.get(i) != o2.get(i)) {
                    return o1.get(i) - o2.get(i);
                }
            }
            return 0;
        });
        return list;
    }

    private static void handle_recursion2(ArrayList<Integer> nums, int index, HashSet<ArrayList<Integer>> res) {
        if (index == nums.size()) {
            ArrayList<Integer> clone = (ArrayList<Integer>) nums.clone();
            res.add(clone);
            return;
        }
        boolean[] visited = new boolean[10];
        for (int i = index; i < nums.size(); i++) {
            if (!visited[nums.get(i)]) {
                visited[nums.get(i)] = true;
                Collections.swap(nums, index, i);
                handle_recursion2(nums, index + 1, res);
                Collections.swap(nums, index, i);//恢复现场
            }
        }
    }
}
