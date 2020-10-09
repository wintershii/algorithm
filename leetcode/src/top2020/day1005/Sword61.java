package top2020.day1005;

import java.util.Arrays;

public class Sword61 {
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int zeroCnt = 0;
        int diff = 0;
        for (int i = 0; i < nums.length - 1; ++i) {
            if (nums[i] == 0) {
                zeroCnt++;
            } else {
                if (nums[i] == nums[i+1]) {
                    return false;
                }
                if (nums[i] + 1 != nums[i+1]) {
                    diff += nums[i+1] - nums[i] - 1;
                }
            }
        }
        return zeroCnt >= diff;
    }
}
