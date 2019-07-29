package leetcode;

import java.util.ArrayList;
import java.util.List;

public class SubSet_78 {

    public static void main(String[] args) {
        System.out.println(new SubSet_78().subsets(new int[]{1,2,3}));
    }


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
}
