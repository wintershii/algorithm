package top2020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 组合总数1，dfs搜索
 */
public class Leetcode39 {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        boolean[] book = new boolean[candidates.length];
        Arrays.sort(candidates);
        //helper(candidates, target, 0, new ArrayList<>());
        helper2(candidates, target, 0, new ArrayList<>());
        return res;
    }

    public void helper(int[] candidates, int target, int i, List<Integer> list) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int start = i; start < candidates.length; ++start) {
            list.add(candidates[start]);
            helper(candidates, target - candidates[start], start, list);
            list.remove(list.size() - 1);
        }
    }

    public void helper2(int[] candidates, int target, int i, List<Integer> list) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int start = i; start < candidates.length; ++start) {
            if (start > i && candidates[start] == candidates[start-1])
                continue;
            list.add(candidates[start]);
            helper2(candidates, target - candidates[start], start+1, list);
            list.remove(list.size() - 1);
        }
    }
}
