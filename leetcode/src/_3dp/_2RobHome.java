package _3dp;

/**
 * 打家劫舍
 * 状态转移方程 : _3dp[i] = MAX(_3dp[i-1],_3dp[i-2]+num[i])
 */
public class _2RobHome {

    /**
     * 1.确定父问题和子问题
     * 2.确定状态
     * 3.确定边界
     * 4.找状态转移方程
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (nums.length < 2) {
            return nums.length == 0 ? 0:nums[0];
        }
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for (int i = 2; i < n; ++i) {
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        return dp[n-1];
    }
}
