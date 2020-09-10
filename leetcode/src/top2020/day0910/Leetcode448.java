package top2020.day0910;

import java.util.ArrayList;
import java.util.List;

/**
 * 找到所有数组中消失的数字
 */
public class Leetcode448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            int index = Math.abs(nums[i]);
            if (nums[index-1] > 0) {
                nums[index-1] = -nums[index-1];
            }
        }
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] > 0) {
                res.add(i+1);
            }
        }
        return res;
    }
}
