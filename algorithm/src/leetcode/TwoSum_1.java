package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class TwoSum_1 {

    public static void main(String[] args) {
        int [] nums = new TwoSum_1().effective(new int[]{3,2,4},6);
        for (int n : nums) {
            System.out.println(n + " ");
        }
    }

    public int[] violence(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; ++i) {
            for (int j = i+1; j < nums.length; ++j) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }

    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        Attom[] attoms = new Attom[len];
        for (int i = 0; i < len; i++) {
            attoms[i] = new Attom();
            attoms[i].value = nums[i];
            attoms[i].set = i;
        }
        Arrays.sort(attoms, (o1, o2) -> o1.value - o2.value);
        for (int i = 0, j = nums.length - 1; i < j; ) {
            if (attoms[i].value + attoms[j].value == target) {
                return new int[]{attoms[i].set,attoms[j].set};
            }
            if (attoms[i].value + attoms[j].value > target) {
                j--;
            }
            if (attoms[i].value + attoms[j].value < target) {
                i++;
            }
        }
        return null;
    }

    class Attom {
        int value;
        int set;
    }

    public int[] effective(int[] nums, int target) {
        HashMap  map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],i);
        }
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i]) && i != (int)map.get(target - nums[i])) {
                return new int[] {i, (int)map.get(target - nums[i])};
            }
        }
        return null;
    }
}
