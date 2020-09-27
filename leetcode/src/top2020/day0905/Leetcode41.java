package top2020.day0905;

/**
 * 第一个缺失的正数
 * 抽屉法
 */
public class Leetcode41 {
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; ++i) {
            while (nums[i] > 0 && nums[i] < nums.length && nums[i] != nums[nums[i] - 1]) {
                int tmp = nums[i];
                nums[i] = nums[nums[i] - 1];
                nums[nums[i] - 1] = tmp;
            }
        }
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != i+1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }
}
