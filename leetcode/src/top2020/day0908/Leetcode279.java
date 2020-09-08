package top2020.day0908;

/**
 * 完全平方数
 *
 */
public class Leetcode279 {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        for (int i = 0; i <= n; ++i) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; ++j) {
                min = Math.min(min, dp[i-j*j]);
            }
            dp[i] = 1 + min;
        }
        return dp[n];
    }
}
