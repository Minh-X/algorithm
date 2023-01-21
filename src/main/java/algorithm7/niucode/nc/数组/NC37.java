package algorithm7.niucode.nc.数组;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * @Author: permission
 * @Date: 2023/1/22 2:19
 * @Version: 1.0
 * @ClassName: NC37
 * @Description: NC37 合并区间
 */
public class NC37 {

    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        ArrayList<Interval> res = (ArrayList<Interval>) intervals.clone();
        res.sort(Comparator.comparingInt(o -> o.start));
        for (int i = 0; i < res.size() - 1; i++) {
            if (res.get(i).end >= res.get(i+1).start) {
                if (res.get(i+1).end <= res.get(i).end) {
                    res.remove(i+1);
                } else {
                    res.get(i).end = res.get(i+1).end;
                    res.remove(i+1);
                }
            }
        }
        return res;
    }


    //  Definition for an interval.
    public class Interval {
        int start;
        int end;
        Interval() {
            start = 0;
            end = 0;
        }
        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }
}
