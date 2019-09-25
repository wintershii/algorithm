package leetcode;

import java.util.*;

public class _18FourNum {
    public static void main(String[] args) {
        System.out.println(new _18FourNum().fourSum(new int[]{-3,-2,-1,0,0,1,2,3},0));
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        Set<List<Integer>> set =  new HashSet<>();
        for (int i = 0; i < nums.length - 3; ++i) {
            for (int j  = i + 1; j < nums.length - 2; ++j) {
                for (int k = j + 1, q = nums.length - 1; k < q; ) {
                    int add = nums[i] + nums[j] + nums[k] + nums[q];
                    if (add == target) {
                        List<Integer> tmp = new ArrayList<>();
                        tmp.add(nums[i]);
                        tmp.add(nums[j]);
                        tmp.add(nums[k]);
                        tmp.add(nums[q]);
                        set.add(tmp);
                    }
                    if (add > target) {
                        --q;
                    }else {
                        ++k;
                    }
                }
            }
        }
        return new ArrayList<>(set);
    }
}
