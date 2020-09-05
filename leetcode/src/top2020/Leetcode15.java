package top2020;

import java.util.*;

/**
 * 三数之和，遍历+双指针
 */
public class Leetcode15 {

    public static void main(String[] args) {
        System.out.println(new Leetcode15().threeSum(new int[]{-1,0,1,2,-1,-4}));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; ++i) {
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                if (nums[i] + nums[j] + nums[k] == 0) {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(nums[i]);
                    tmp.add(nums[j]);
                    tmp.add(nums[k]);
                    set.add(tmp);
                    j++;
                    k--;
                } else if (nums[i] + nums[j] + nums[k] < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return new ArrayList<>(set);
    }
}
