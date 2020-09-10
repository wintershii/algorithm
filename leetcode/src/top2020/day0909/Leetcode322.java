package top2020.day0909;

/**
 * 零钱兑换
 */
public class Leetcode322 {
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount+1];
        for (int i = 1; i <= amount; ++i) {
            dp[i] = max;
        }
        for (int i = 0; i < coins.length; ++i) {
            for (int j = coins[i]; j <= amount; ++j) {
                dp[j] = Math.min(dp[j], dp[j-coins[i]]+1);
            }
        }
        return dp[amount] == max ? -1 : dp[amount];
    }
}
