package leetcode;

/**
 * 分发糖果
 * 动态规划
 */
public class _135Candy {
    public int candy(int[] ratings) {
        int num = ratings.length;
        int[] dp = new int[num];
        dp[0] = 1;
        for (int i = 1; i < num; ++i) {
            if (ratings[i] > ratings[i-1]) {
                dp[i] = dp[i-1] + 1;
            } else {
                dp[i] = 1;
            }
        }
        int res = dp[num-1];
        for (int i = num-2; i >=0; --i) {
            if (ratings[i] > ratings[i+1] && dp[i] <= dp[i+1]) {
                dp[i] = dp[i+1] + 1;
            }
            res += dp[i];
        }
        return res;
    }
}
