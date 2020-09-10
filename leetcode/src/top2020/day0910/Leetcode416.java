package top2020.day0910;

/**
 * 分割等和子集
 * 思路，求的总和sum，sum一定是偶数
 * 转换位01背包问题
 * i 遍历num
 * j k -> num  dp[j] += dp[j-num];
 */
public class Leetcode416 {
    public boolean canPartition(int[] nums) {
        if (nums.length < 2) {
            return false;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int k = sum / 2;
        int[] dp = new int[k+1];
        dp[0] = 1;
        for (int num : nums) {
            for (int i = k; i >= num; --i) {
                dp[i] += dp[i-num];
            }
        }
        return dp[k] != 0;
    }
}
