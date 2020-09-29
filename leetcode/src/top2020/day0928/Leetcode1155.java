package top2020.day0928;

public class Leetcode1155 {
    public int numRollsToTarget(int d, int f, int target) {
        int mod = 1000000007;
        int[][] dp = new int[d+1][target+1];
        for (int i = 1; i <= d; ++i) {
            for (int j = i; j <= f*i; ++j) {
                for (int k = 1; k <= f; ++k) {
                    if (k > j)  break;
                    dp[i][j] = (dp[i][j] + dp[i-1][j-k]) % mod;
                }
            }
        }
        return dp[d][target];
    }
}
