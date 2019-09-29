package leetcode;

public class _41FirstMissingPositive {

    public static void main(String[] args) {
        System.out.println(new _41FirstMissingPositive().firstMissingPositive(new int[]{3,4,-1,1}));
    }

    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == i + 1) {
                continue;
            }
            if (nums[i] > 0 && nums[i] <= nums.length) {
                if (nums[i] < nums.length && nums[i]+1 == nums[nums[i]]) {
                    continue;
                }
                int tmp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = tmp;
                i--;
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
