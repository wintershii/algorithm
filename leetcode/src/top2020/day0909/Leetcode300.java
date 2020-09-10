package top2020.day0909;

import java.util.Arrays;

/**
 *
 */
public class Leetcode300 {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length < 2) {
            return nums.length < 1 ? 0 : 1;
        }
        int[] dp = new int[nums.length+1];
        dp[0] = 0;
        dp[1] = 1;
        int res = 0;
        for (int i = 2; i <= nums.length; ++i) {
            dp[i] = 1;
            for (int j = 1; j < i; ++j) {
                if (nums[i-1] > nums[j-1]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            res = Math.max(dp[i], res);
        }
        return res;
    }

    public int lengthOfLIS2(int[] nums) {
        int[] res = new int[nums.length];
        int len = 0;
        for (int num: nums) {
            int idx = Arrays.binarySearch(res, 0, len, num);
            idx = idx < 0? -idx - 1: idx;
            res[idx] = num;
            if (idx == len) {
                len++;
            }
        }
        return len;
    }
}
