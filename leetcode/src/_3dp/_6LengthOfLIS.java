package _3dp;

/**
 * 最长上升子序列
 */
public class _6LengthOfLIS {

    public static void main(String[] args) {
        System.out.println(new _6LengthOfLIS().lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
    }


    /**
     * 状态转移方程 , 双层循环, 内部循环从0-i
     * if(nums[i] > nums[j] && _3dp[i] <= _3dp[j])
     * _3dp[i] = _3dp[j] + 1
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        if (nums.length < 2) {
            return nums.length < 1 ? 0 : 1;
        }
        int[] dp = new int[nums.length+1];
        dp[0] = 0;
        dp[1] = 1;
        int res = Integer.MIN_VALUE;
        for (int i = 2; i <= nums.length; ++i) {
            dp[i] = 1;
            for (int j = 1; j < i; ++j) {
                if (nums[i-1] > nums[j-1] && dp[i] <= dp[j]) {
                    dp[i] = dp[j] + 1;
                }
            }
            if (dp[i] > res) {
                res = dp[i];
            }
        }
        return res;
    }
}
