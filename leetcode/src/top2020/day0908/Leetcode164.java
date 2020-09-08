package top2020.day0908;

/**
 * 最大间距
 * 桶排序+鸽笼定理
 * On
 */
public class Leetcode164 {
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int i = 0 ; i < nums.length; ++i) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }
        if (max == min)
            return 0;
        int len = nums.length;
        boolean[] hasNum = new boolean[len+1];
        int[] bucketMin = new int[len+1];
        int[] bucketMax = new int[len+1];
        for (int i = 0; i < nums.length; ++i) {
            int index = mapToBucket(nums[i], len, max, min);
            bucketMax[index] = hasNum[index] ? Math.max(bucketMax[index], nums[i]) : nums[i];
            bucketMin[index] = hasNum[index] ? Math.min(bucketMin[index], nums[i]) : nums[i];
            hasNum[index] = true;
        }
        int res = 0, preMax = bucketMax[0];
        for (int i = 1; i <= len; ++i) {
            if (hasNum[i]) {
                res = Math.max(res, bucketMin[i] - preMax);
                preMax = bucketMax[i];
            }
        }
        return res;
    }

    public int mapToBucket(long num, long len, long max, long min) {
        return (int) ((num - min) * len / (max - min));
    }
}
