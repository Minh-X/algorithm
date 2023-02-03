package algorithm7.leetcode.字符串;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * @Author: permission
 * @Date: 2023/2/3 21:21
 * @Version: 1.0
 * @ClassName: LC609
 * @Description: 609. 在系统中查找重复文件
 */
public class LC609 {

    public static void main(String[] args) {
        String[] paths =
                {
                        "root/a 1.txt(abcd) 2.txt(efgh)",
                        "root/c 3.txt(abcd)",
                        "root/c/d 4.txt(efgh)",
                        "root 4.txt(efgh)"};
                        /*
                            "root/a/2.txt",
                            "root/c/d/4.txt",
                            "root/4.txt",

                            "root/a/1.txt",
                            "root/c/3.txt"
                         */
        List<List<String>> res = findDuplicate(paths);

        for (List<String> list : res) {
            for (String s : list) {
                System.out.print(s + "   |||   ");
            }
            System.out.println();
        }

    }

    public static List<List<String>> findDuplicate(String[] paths) {
        return handle(paths);

    }

    private static List<List<String>> handle(String[] paths) {

        HashMap<String, List<String>> map = new HashMap<>();
        for (String path : paths) {
            String[] splits = path.split(" ");
            for (int i = 1; i < splits.length; i++) {
                String[] name_content = splits[i].split("\\(");
                name_content[1] = name_content[1].replace(")", "");
                // "root/a 1.txt(abcd) 2.txt(efgh)",
                List<String> list = map.getOrDefault(name_content[1], new ArrayList<>());
                list.add(splits[0] + "/" + name_content[0]);
                map.put(name_content[1], list);
            }
        }
        List<List<String>> res = new ArrayList<>();
        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            if (map.get(key).size() > 1) {//大于1才是重复的
                res.add(map.get(key));
            }
        }
        return res;
    }

}
