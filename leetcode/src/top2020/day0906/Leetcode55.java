package top2020.day0906;

/**
 * 跳跃游戏
 * 贪心算法
 *
 */
public class Leetcode55 {
    public boolean canJump(int[] nums) {
        if (nums.length == 0) {
            return true;
        }
        int cur = nums[0], i = 1;
        for (; cur != 0 && i < nums.length; ++i) {
            cur--;
            if (cur < nums[i]) {
                cur = nums[i];
            }
        }
        return i == nums.length;
    }
}
