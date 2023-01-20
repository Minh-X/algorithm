package algorithm7.niucode.nc.贪心;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * @Author: permission
 * @Date: 2023/1/18 18:53
 * @Version: 1.0
 * @ClassName: NC392
 * @Description: NC392 参加会议的最大数目
 */
public class NC392 {

    /*
            NC上测试用例貌似有问题，过不了 题目对应LC1353
     */
    public int attendmeetings(ArrayList<ArrayList<Integer>> meetings) {
        // write code here
        return attendmeetings_Greedy(meetings);
    }

    /*
            使用贪心
                策略为 优先会议结束时间早的
     */
    private int attendmeetings_Greedy(ArrayList<ArrayList<Integer>> meetings) {
        // 自定义比较器，按照每场会议结束时间进行排序
        meetings.sort(new MyComparator());
        int timeLine = 0;
        int result = 0;
        for (int i = 0; i < meetings.size(); i++) {
            if (meetings.get(i).get(0) >= timeLine) {
                result++;
                timeLine = meetings.get(i).get(1);
            }
        }
        return result;
    }

    public static class MyComparator implements Comparator<ArrayList<Integer>> {
        @Override
        public int compare(ArrayList o1, ArrayList o2) {
            return (int) o1.get(1) - (int) o2.get(1);
        }
    }
}
