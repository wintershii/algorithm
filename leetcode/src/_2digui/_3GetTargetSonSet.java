package _2digui;

import java.util.*;

/**
 * 组合数之和
 * 已知一组数(有重复元素), 求这组数可以组成的所有子集中
 * 子集中的各个元素和为整数target的子集, 结果中无重复的子集
 */
public class _3GetTargetSonSet {

    public static void main(String[] args) {
        System.out.println(new _3GetTargetSonSet().combinationSum2(new int[]{10,1,2,7,6,1,5}, 8));
    }

    Set<List<Integer>> res = new HashSet<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> list = new ArrayList<>();
        generate(0,candidates,target,list,0);
        return new ArrayList<>(res);
    }

    public void generate(int i, int[] nums, int target, List<Integer> list, int now) {
        /**
         * 剪枝
         */
        if (now > target) {
            return;
        }
        if (i == nums.length) {
            if (now == target) {
                res.add(list);
            }
            return;
        }
        List<Integer> newList = new ArrayList<>(list);
        generate(i+1, nums, target, list, now);
        newList.add(nums[i]);
        generate(i+1, nums, target, newList, now+nums[i]);
    }
}
