package classify._3dp;

/**
 * 上楼梯, 经典的题目, 与斐波那契相似
 * 动态规划 : 1.确认原问题和子问题
 *          2.确认状态
 *          3.确认边界的值
 *          4.确认状态转移方程
 */
public class _1UpStair {


    /**
     * 初始动态规划, 使用数组保存
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; ++i) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    /**
     * 暴力搜索
     * @param n
     * @return
     */
    public int search(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return search(n-1) + search(n-2);
    }
}
