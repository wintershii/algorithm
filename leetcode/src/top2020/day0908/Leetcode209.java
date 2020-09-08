package top2020.day0908;

/**
 * 长度最小的子数组
 * 滑动窗口
 */
public class Leetcode209 {
    public int minSubArrayLen(int s, int[] nums) {
        int res = Integer.MAX_VALUE;
        int i = 0, j = 0;
        int sum = 0;
        while (j < nums.length) {
            if (sum + nums[j] < s) {
                sum += nums[j++];
            } else {
                res = Math.min(res, j-i+1);
                sum -= nums[i++];
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
