package digui;

import java.util.ArrayList;
import java.util.List;

/**
 * 求子集
 * 已知一组数(其中无重复元素),求这组数可以组成的所有子集
 * 结果中不可有重复的子集
 */
public class _1GetSonSet {

    List<List<Integer>> res = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(new _1GetSonSet().bitSolve(new int[]{1,2,3}));
    }

    /**
     * 另外一种思路
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets2(int[] nums) {
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
     * 递归+回溯 对每个元素试探放入或不放入
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int nums[]) {
        res.add(new ArrayList<>());
        if (nums == null || nums.length == 0) {
            return res;
        }
        List<Integer> list = new ArrayList<>();
        generate(0,nums,list);
        return res;
    }

    public void generate(int i, int[] nums, List<Integer> list) {
        if (i > nums.length -1) {
            return;
        }
        list.add(nums[i]);
        res.add(new ArrayList<>(list));
        generate(i+1,nums,list);
        list.remove(list.size()-1);
        generate(i+1,nums,list);
    }

    /**
     * 位运算法
     */
    public List<List<Integer>> bitSolve(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int allSet = 1 << nums.length;
        for (int i = 0; i < allSet; ++i) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < nums.length; ++j) {
                if ((i & (1 << j)) != 0) {
                    list.add(nums[j]);
                }
            }
            res.add(list);
        }
        return res;
    }
}
