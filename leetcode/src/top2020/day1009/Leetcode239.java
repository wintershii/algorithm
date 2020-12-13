package top2020.day1009;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 滑动窗口最大值
 * 单调双端队列
 */
public class Leetcode239 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return nums;
        }
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < nums.length; ++i) {
            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
                queue.pollLast();
            }
            queue.add(i);
            if (queue.peekFirst() <= i - k) {
                queue.pollFirst();
            }
            if (i - k + 1 >= 0) {
                res[i-k+1] = nums[queue.peekFirst()];
            }
        }
        return res;
    }
}
