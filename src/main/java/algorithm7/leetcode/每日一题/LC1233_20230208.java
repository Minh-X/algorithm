package algorithm7.leetcode.每日一题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: permission
 * @Date: 2023/2/8 13:58
 * @Version: 1.0
 * @ClassName: LC1233_20230208
 * @Description: 1233. 删除子文件夹
 */
public class LC1233_20230208 {

    public static void main(String[] args) {
        String[] folder = {"/c/d/e", "/a", "/a/b", "/c/d", "/c/f"};
        List<String> res = removeSubfolders(folder);
        System.out.println("---------------res---------------");
        for (String s : res) {
            System.out.println(s);
        }
    }

    public static List<String> removeSubfolders(String[] folder) {
        return handle_sort(folder);
    }

    private static List<String> handle_sort(String[] folder) {
        Arrays.sort(folder);
        List<String> res = new ArrayList<>();
        res.add(folder[0]);
        for (int i = 1; i < folder.length; i++) {
            String prefix = res.get(res.size() - 1) + "/";
            if (!folder[i].startsWith(prefix)) {
                res.add(folder[i]);
            }
        }
        return res;
    }
}
