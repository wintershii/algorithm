package top2020.day0910;

import java.util.Arrays;

/**
 * 任务调度器
 */
public class Leetcode621 {
    public int leastInterval(char[] tasks, int n) {
        if (tasks.length <= 1 || n < 1) {
            return tasks.length;
        }
        int[] count = new int[26];
        for (int i = 0; i < tasks.length; ++i) {
            count[tasks[i] - 'A']++;
        }
        Arrays.sort(count);
        int max = count[25];
        int res = (max-1) * (n+1) + 1;
        for (int i = count.length - 2; i >= 0; --i) {
            if (count[i] == max) {
                res++;
            } else {
                break;
            }
        }
        return Math.max(res, tasks.length);
    }
}
