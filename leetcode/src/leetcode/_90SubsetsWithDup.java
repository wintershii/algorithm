package leetcode;

import java.util.*;

/**
 * 包含重复数字的集合里找子集
 */
public class _90SubsetsWithDup {

    //使用Set来实现去重
    Set<List<Integer>> result = new HashSet<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> list = new ArrayList<>();
        //提前排好序, 保证结果有序
        Arrays.sort(nums);
        dfs(nums,0,list);
        return new ArrayList<>(result);
    }

    public void dfs(int[] nums, int now, List<Integer> list) {
        //出口
        if (now == nums.length) {
            result.add(list);
            return;
        }
        ArrayList<Integer> newList = new ArrayList<>(list);
        //不包含当前元素搜索
        dfs(nums,now+1,list);
        newList.add(nums[now]);
        //包含当前元素搜索
        dfs(nums,now+1,newList);
    }


}
