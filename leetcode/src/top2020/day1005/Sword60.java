package top2020.day1005;

public class Sword60 {
    public double[] twoSum(int n) {
        int[][] dp = new int[n+1][6 * n + 1];
        double[] res = new double[5 * n + 1];
        double all = Math.pow(6, n);
        for (int i = 1; i <= 6; ++i) {
            dp[1][i] = 1;
        }
        for (int i = 1; i <= n; ++i) {
            for (int j = i; j <= 6 * n; ++j) {
                for (int k = 1; k <= 6; ++k) {
                    if (j >= k) {
                        dp[i][j] += dp[i-1][j-k];
                    }
                    if (i == n) {
                        res[j-i] = dp[i][j] / all;
                    }
                }
            }
        }
        return res;
    }
}
