package leetcode;

/**
 * 第一个丢失的正整数
 * 思路:将i放在i-1位置上
 */
public class _41FirstMissingPositive {

    public static void main(String[] args) {
        System.out.println(new _41FirstMissingPositive().firstMissingPositive(new int[]{3,4,-1,1}));
    }

    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; ++i) {
            while (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]) {
                int tmp = nums[i];
                nums[i] = nums[nums[i] - 1];
                nums[tmp - 1] = tmp;
            }
        }
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }
}
