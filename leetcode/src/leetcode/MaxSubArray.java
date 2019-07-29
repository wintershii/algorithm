package leetcode;

public class MaxSubArray {
    public static void main(String[] args) {

    }

    public int maxSubArray(int[] nums) {
        int cur_sum = nums[0];
        int max_sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (cur_sum > 0) cur_sum += nums[i];
            else cur_sum = nums[i];
            if (cur_sum > max_sum) max_sum = cur_sum;
        }
        return max_sum;
    }
}
