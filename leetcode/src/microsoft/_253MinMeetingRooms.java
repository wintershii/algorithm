package microsoft;

import java.util.Arrays;

/**
 * 给定一个会议时间安排的数组，每个会议时间都会包括开始和结束的时间 [[s1,e1],[s2,e2],...] (si < ei)，为避免会议冲突，同时要考虑充分利用会议室资源，请你计算至少需要多少间会议室，才能满足这些会议安排。
 *
 * 示例 1:
 *
 * 输入: [[0, 30],[5, 10],[15, 20]]
 * 输出: 2
 * 示例 2:
 *
 * 输入: [[7,10],[2,4]]
 * 输出: 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/meeting-rooms-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _253MinMeetingRooms {

    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0 || intervals[0].length == 0) {
            return 0;
        }
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        for (int i = 0; i < intervals.length; ++i) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);

        int res = 0, active = 0;
        int i = 0, j = 0;
        while (i < intervals.length && j < intervals.length) {
            if (start[i] < end[j]) {
                active++;
                i++;
            } else {
                active--;
                j++;
            }
            res = Math.max(res,active);
        }
        return res;
    }
}
