package array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeGap {
    public static void main(String[] args) {

    }

    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        if (intervals.size() < 1) {
            return result;
        }

        Interval p = intervals.get(0);
        Interval temp;

        for (int i = 1; i < intervals.size(); i++) {
            temp = intervals.get(i);
            if (p.end >= temp.start) {
                p.end = Math.max(p.end,temp.end);
            } else {
                result.add(p);
                p = temp;
            }
        }
        result.add(p);
        return result;
    }
}
