package top2020.day0908;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 滑动窗口最大值
 * 维护一个队列，以及一个curMax
 * 每次向后移动一个坐标，如果当前值小于最大值则直接赋值并继续
 * 若当前值小于最大值，则要判断最大值是不是即将出队列的那个数
 * 如果是则需要从i-k+1 -> i找到新的的最大值并赋值
 */
public class Leetcode239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 1) {
            return nums;
        }
        int[] res = new int[nums.length];
        Queue<Integer> queue = new LinkedList<>();
        int curMax = Integer.MIN_VALUE;
        for (int i = 0; i < k; ++i) {
            queue.offer(nums[i]);
            if (nums[i] > curMax) {
                curMax = nums[i];
            }
        }
        res[0] = curMax;
        for (int i = k; i < nums.length; ++i) {
            queue.offer(nums[i]);
            if (nums[i] >= curMax) {
                curMax = nums[i];
                res[i-k+1] = curMax;
                queue.poll();
                continue;
            }
            if (!queue.isEmpty() && queue.poll() == curMax) {
                int newMax = Integer.MIN_VALUE;
                for (int j = i-k+1; j <= i; ++j) {
                    newMax = Math.max(newMax, nums[j]);
                }
                curMax = newMax;
            }
            res[i-k+1] = curMax;
        }
        return res;
    }
}
