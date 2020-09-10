package top2020.day0910;

/**
 * 最短无序连续子数组
 * 思路：双指针 一左一右， max从左向右，min从右向左，遇到更大或更小就更新。遇到比max小的或比min大的就更新left和right
 * 最后结果是right-left+1
 */
public class Leetcode581 {
    public int findUnsortedSubarray(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        int max = nums[0];
        int min = nums[nums.length-1];
        int left = 0;
        int right = nums.length - 1;
        for (int i = 1; i < nums.length; ++i) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[nums.length - i - 1]);
            if (nums[i] < max) {
                left = i;
            }
            if (nums[nums.length - i - 1] > min) {
                right = nums.length - i - 1;
            }
        }
        return left > right ? right - left + 1 : 0;
    }
}
