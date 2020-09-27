package top2020.day0927;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode47 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] book = new boolean[nums.length];
        Arrays.sort(nums);
        helper(nums, book, res, 0, new ArrayList<>());
        return res;
    }

    public void helper(int[] nums, boolean[] book, List<List<Integer>> res, int index,
                       List<Integer> list) {
        if (index == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i <= nums.length; ++i) {
            if (!book[index]) {
                if (i > 0 && nums[i] == nums[i-1] && !book[i-1]) {
                    continue;
                }
                list.add(nums[i]);
                book[i] = true;
                helper(nums, book, res, index+1, list);
                book[i] = false;
                list.remove(list.size()-1);
            }
        }
    }

}
