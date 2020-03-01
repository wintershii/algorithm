package classify._2digui;

import java.util.*;

/**
 * 子集2
 * 在含有重复元素的数组中找出所有不重复的子集
 *
 *使用set去重
 */
public class _2GetDifSonSet {


    Set<List<Integer>> res = new HashSet<>();


    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        generate(0,nums,list);
        return new ArrayList<>(res);
    }

    public void generate(int i, int[] nums, List<Integer> list) {
        if (i == nums.length) {
            res.add(list);
            return;
        }
        List<Integer> newList = new ArrayList<>(list);
        generate(i+1, nums, list);
        newList.add(nums[i]);
        generate(i+1, nums, newList);
    }
}
