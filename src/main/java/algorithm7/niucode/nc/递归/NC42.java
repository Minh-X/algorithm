package algorithm7.niucode.nc.递归;

import java.util.*;

/**
 * @Author: permission
 * @Date: 2023/1/29 15:50
 * @Version: 1.0
 * @ClassName: NC42
 * @Description: NC42 有重复项数字的全排列
 */
public class NC42 {

    public static void main(String[] args) {
        int[] ccc = {1, 1, 2};
        ArrayList<ArrayList<Integer>> res = permuteUnique2(ccc);
        for (ArrayList<Integer> re : res) {
            for (Object o : re.toArray()) {
                System.out.print(o.toString() + " ");
            }
            System.out.println();
        }
    }

    public static ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        Arrays.sort(num);
        ArrayList<Integer> rest = new ArrayList<>();
        for (int i : num) {
            rest.add(i);
        }
        HashSet<ArrayList<Integer>> res = new HashSet<>();
        handle_recursion(rest, res, new ArrayList<>());
        List<ArrayList<Integer>> list = new ArrayList<>();
        for (ArrayList<Integer> re : res) {
            list.add(re);
        }
        ArrayList<ArrayList<Integer>> collect = (ArrayList<ArrayList<Integer>>) list;
        collect.sort(new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                for (int i = 0; i < o1.size(); i++) {
                    if (o1.get(i) != o2.get(i)) {
                        return o1.get(i) - o2.get(i);
                    }
                }
                return 0;
            }
        });
        return collect;
    }
    private static void handle_recursion(ArrayList<Integer> rest, HashSet<ArrayList<Integer>> res, ArrayList<Integer> subs) {
        if (rest.isEmpty()) {
            res.add(subs);
            return;
        }
        int n = rest.size();
        for (int i = 0; i < n; i++) {
            Integer numI = rest.get(i);
            rest.remove(i);
//            subs.add(numI);
//            handle_recursion(rest, res, subs);
            ArrayList<Integer> clone = (ArrayList<Integer>) subs.clone();
            clone.add(numI);
            handle_recursion(rest, res, clone);
            rest.add(i, numI);//恢复现场
        }
    }

    public static ArrayList<ArrayList<Integer>> permuteUnique2(int[] num) {
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
        for (int i = index; i < nums.size(); i++) {
            Collections.swap(nums, index, i);
            handle_recursion2(nums, index + 1, res);
            Collections.swap(nums, index, i);
        }
    }


}
