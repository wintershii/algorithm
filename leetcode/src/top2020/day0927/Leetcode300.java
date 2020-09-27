package top2020.day0927;

public class Leetcode300 {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            int left = 0, right = len;
            while (left < right) {
                int mid = (left + right) >> 1;
                if (dp[mid] < num) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            dp[left] = num;
            if (left == len) {
                len++;
            }
        }
        return len;
    }
}
