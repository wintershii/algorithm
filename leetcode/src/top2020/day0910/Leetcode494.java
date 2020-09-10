package top2020.day0910;

/**
 * 目标和
 * 输入：nums: [1, 1, 1, 1, 1], S: 3
 * 输出：5
 * 解释：
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 */
public class Leetcode494 {
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int max = sum + S;
        if (sum < S || max % 2 != 0) {
            return 0;
        }
        int k = max / 2;
        int[] dp = new int[k+1];
        dp[0] = 1;
        for (int num : nums) {
            for (int i = k; i >= num; --i) {
                dp[i] += dp[i-num];
            }
        }
        return dp[k];
    }
}
