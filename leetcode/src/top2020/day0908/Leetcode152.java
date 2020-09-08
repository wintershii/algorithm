package top2020.day0908;

import java.util.Map;

/**
 * 乘积最大的子数组
 * 思路：保存一个最大值和最小值。遍历数组，遇到负数就互换一次，每次选继续乘或者当前的数。
 * 最后比较结果和最大值选最大的
 */
public class Leetcode152 {
    public int maxProduct(int[] nums) {
        int res = Integer.MIN_VALUE;
        int curMax = 1, curMin = 1;
        for (int num :  nums) {
            if (num < 0) {
                int tmp = curMax;
                curMax = curMin;
                curMin = tmp;
            }
            curMax = Math.max(num, curMax * num);
            curMin = Math.min(num, curMin * num);
            res = Math.max(res, curMax);
        }
        return res;
    }
}
