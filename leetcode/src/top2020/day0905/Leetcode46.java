package top2020.day0905;

import java.util.ArrayList;
import java.util.List;

/**
 * 全排列
 */
public class Leetcode46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] book = new boolean[nums.length];
        helper(nums, 0, book, res, new ArrayList<>());
        return res;
    }

    public void helper(int[] nums, int index, boolean[] book, List<List<Integer>> res, List<Integer> list) {
        if (index >= nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (!book[i]) {
                book[i] = true;
                list.add(nums[i]);
                helper(nums, index+1,book,res,list);
                book[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }
}
