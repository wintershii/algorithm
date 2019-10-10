package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _78SubSet {

    public static void main(String[] args) {
        System.out.println(new _78SubSet().subsets(new int[]{1,2,3}));
    }

    List<List<Integer>> res;

    /**
     * 一种不用递归的写法
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int len = list.size();
            for (int j = 0; j < len; j++) {
                List<Integer> add = new ArrayList<>(list.get(j));
                add.add(nums[i]);
                list.add(add);
            }
            List<Integer> tmp = new ArrayList<>();
            tmp.add(nums[i]);
            list.add(tmp);
        }
        list.add(new ArrayList<>());
        return list;
    }

    /**
     * 自己写的搜索
     */
    public List<List<Integer>> subsets2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        res = new ArrayList<>();
        search(nums,0,new ArrayList());
        return res;
    }

    private void search(int[] nums, int now, List<Integer> list) {
        if (now == nums.length) {
            res.add(list);
            return;
        }
        List<Integer> newList = new ArrayList<>(list);
        search(nums,now+1,list);
        newList.add(nums[now]);
        search(nums,now+1,newList);
    }
}
