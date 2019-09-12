package _3dp;

/**
 * 最大子段和
 * 求给定数组的连续子数组中, 最大的那一段
 * 求出以第i个数为结尾的最大子段和
 * 状态转移方程 : _3dp[i] = _3dp[i-1] < 0 ? _3dp[i-1]+nums[i] : nums[i]
 */
public class _3MaxSubmentSum {

    /**
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        if (nums.length < 2) {
            return nums.length == 0 ? 0:nums[0];
        }
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int res = dp[0];
        for (int i = 1; i < n; ++i) {
            dp[i] = Math.max(dp[i-1]+nums[i],nums[i]);
            if (dp[i] > res) {
                res = dp[i];
            }
        }
        return res;
    }
}
