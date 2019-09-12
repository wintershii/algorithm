package _3dp;

/**
 * 找零钱
 * 类似背包问题
 * 不同面值的钞票, 用最少数量的钞票组成某个金额
 * 传入一个钞票数组(面值),和一个金额
 * 返回需要的最少钞票数量
 */
public class _4CoinChange {
    public static void main(String[] args) {
        System.out.println(new _4CoinChange().solve(new int[]{2},1));
    }


    /**
     * 状态i表示金额i所需的最少张数
     * 状态转移方程 : 枚举出数组中和金额有关的(即金额减去各个面值)中最少的需要张数+1 就是最终结果
     *
     * 当 i-coins[j] >=0 且 _3dp[i-coins[j]] != -1时
     * _3dp[i] =getmin(_3dp[i-coins[j]]) + 1
     *
     * 超时......
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        int[] dp = new int[amount+1];
        dp[0] = 0;
        for (int i = 0; i <= amount; ++i) {
            dp[i] = -1;
        }
        for (int i = 1; i <= amount; ++i) {
                for (int j = 0; j < coins.length; ++j) {
                    if (i == coins[j]) {
                        dp[i] = 1;
                    } else if (coins[j] < i && dp[i-coins[j]] != -1) {
                        if (dp[i] == -1 || dp[i] > dp[i-coins[j]] + 1) {
                            dp[i] = dp[i-coins[j]] + 1;
                        }
                    }
                }
            System.out.println(i + " :" + dp[i]);
        }
        return dp[amount];
    }

    /**
     * DP进行优化
     * @param coins
     * @param amount
     * @return
     */
    public int solve(int[] coins, int amount) {
        int M = amount + 1;
        int[] dp = new int[amount+1];
        for (int i = 1; i <= amount; ++i) {
            dp[i] = M;
        }
        dp[0] = 0;
        for (int i = 0; i < coins.length; ++i) {
            for (int j = coins[i]; j < amount + 1; ++j) {
                dp[j] = Math.min(dp[j],dp[j-coins[i]]+1);
            }
        }
        return dp[amount] < M ? dp[amount] : -1;
    }


}
