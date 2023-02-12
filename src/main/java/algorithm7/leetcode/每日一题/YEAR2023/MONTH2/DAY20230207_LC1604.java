package algorithm7.leetcode.每日一题.YEAR2023.MONTH2;

import java.util.*;

/**
 * @Author: permission
 * @Date: 2023/2/7 21:42
 * @Version: 1.0
 * @ClassName: LC1604_20230207
 * @Description: 警告一小时内使用相同员工卡大于等于三次的人
 */
public class DAY20230207_LC1604 {


    public static void main(String[] args) {
        String[] keyName = {"daniel", "daniel", "daniel", "luis", "luis", "luis", "luis"};
        String[] keyTime = {"10:00", "10:40", "11:00", "09:00", "11:00", "13:00", "15:00"};
        List<String> res = alertNames(keyName, keyTime);
        for (String name : res) {
            System.out.println(name);
        }
    }

    public static List<String> alertNames(String[] keyName, String[] keyTime) {
        return handle(keyName, keyTime);
    }

    private static List<String> handle(String[] keyName, String[] keyTime) {
        Map<String, List<Integer>> timeMap = new HashMap<>();
        int n = keyName.length;
        for (int i = 0; i < n; i++) {
            String name = keyName[i];
            String time = keyTime[i];
            timeMap.putIfAbsent(name, new ArrayList<>());
            int hour = (time.charAt(0) - '0') * 10 + (time.charAt(1) - '0');
            int minute = (time.charAt(3) - '0') * 10 + (time.charAt(4) - '0');
            timeMap.get(name).add(hour * 60 + minute);
        }
        List<String> res = new ArrayList<>();
        Set<String> nameSet = timeMap.keySet();//所有人name
        for (String name : nameSet) {
            List<Integer> list = timeMap.get(name);//名为name的所有打卡记录
            Collections.sort(list);//排序
            int size = list.size();
            for (int i = 2; i < size; i++) {//每60分打卡3次，所以可以直接看第0次和第2次的间隔
                int dif = list.get(i) - list.get(i - 2);
                if (dif <= 60) {
                    res.add(name);
                    break;
                }
            }
        }
        Collections.sort(res);
        return res;
    }
}
