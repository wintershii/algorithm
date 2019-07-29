package leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class ThreeNumClosest {
    public static void main(String[] args) {
        int[] arr = new int[]{0,2,1,-3};
        System.out.println(new ThreeNumClosest().threeSumClosest(arr,1));
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[2];
        int min = Math.abs(result - target);
        for (int i = 0; i < nums.length - 2; ++i) {
            for (int j = i + 1, k = nums.length - 1; j < k; ) {
                int add = nums[i] + nums[j]  + nums[k];
                if (Math.abs(add - target) < min) {
                    min = Math.abs(add - target);
                    result = add;
                }
                if (add > target) {
                    k--;
                } else if (add < target){
                    j++;
                } else {
                    return result;
                }

            }
        }
        return result;
    }


}
