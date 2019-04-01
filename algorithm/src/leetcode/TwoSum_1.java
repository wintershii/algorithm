package leetcode;

public class TwoSum_1 {

    public static void main(String[] args) {
        int [] nums = new TwoSum_1().twoSum(new int[]{2,7,11,15},9);
        for (int n : nums) {
            System.out.println(n + " ");
        }
    }

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; ++i) {
            for (int j = i+1; j < nums.length; ++j) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }
}
