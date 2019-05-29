package leetcode;

import java.util.*;

public class SubsetsWithDup_90 {

    Set<List<Integer>> result = new HashSet<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> list = new ArrayList<>();
        dfs(nums,0,list);
        return new ArrayList<>(result);
    }

    public void dfs(int[] nums, int now, List<Integer> list) {
        if (now == nums.length) {
            Collections.sort(list);
            result.add(list);
            return;
        }
        ArrayList<Integer> newList = new ArrayList<>(list);
        dfs(nums,now+1,list);
        newList.add(nums[now]);
        dfs(nums,now+1,newList);
    }


}
