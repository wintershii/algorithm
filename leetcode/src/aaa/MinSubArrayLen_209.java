package aaa;

/**
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。如果不存在符合条件的连续子数组，返回 0。
 *
 * 示例: 
 *
 * 输入: s = 7, nums = [2,3,1,2,4,3]
 * 输出: 2
 * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-size-subarray-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinSubArrayLen_209 {
    public int minSubArrayLen(int s, int[] nums) {
        int len = Integer.MAX_VALUE;
        int i = 0, j = 0;
        int sum = 0;
        while (i < nums.length) {
            if (sum + nums[i] < s) {
                sum += nums[i++];
            } else {
                len = Math.min(len, i - j + 1);
                sum -= nums[j++];
            }
        }
        return len == Integer.MAX_VALUE ? 0 : len;
    }
}
