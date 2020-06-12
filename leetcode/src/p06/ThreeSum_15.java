package p06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum_15 {

    public static void main(String[] args) {
        System.out.println(new ThreeSum_15().threeSum(new int[]{-1,0,1,2,-1,-4}));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; ++i) {
            if (i == 0 || (i > 0 && nums[i] != nums[i-1])) {
                int j = i + 1;
                int k = nums.length - 1;
                while (j < k) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        res.add(list);
                        while (j < k && nums[j] == nums[j+1]) j++;
                        while (j < k && nums[k] == nums[k-1]) k--;
                        j++;
                        k--;
                    } else if (nums[i] + nums[j] + nums[k] < 0) {
                        while (j < k && nums[j] == nums[j+1]) j++;
                        j++;
                    } else {
                        while (j < k && nums[k] == nums[k-1]) k--;
                        k--;
                    }
                }
            }

        }
        return res;
    }
}
