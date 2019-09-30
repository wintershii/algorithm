package array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 题目：合并区间
 * 来源:leetcode字节跳动专栏
 */
public class MergeGap {
    public static void main(String[] args) {

    }

    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();
        //根据起始节点排序
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

        //遍历整个list
        for (int i = 1; i < intervals.size(); i++) {
            temp = intervals.get(i);
            //判断前一个的末尾是否覆盖下一个的开始, 然后求出真正的末尾
            if (p.end >= temp.start) {
                p.end = Math.max(p.end,temp.end);
            } else {
                //没有覆盖关系, 加入res中.
                result.add(p);
                p = temp;
            }
        }
        result.add(p);
        return result;
    }
}
