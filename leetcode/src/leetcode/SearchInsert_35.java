package leetcode;

public class SearchInsert_35 {
    public static void main(String[] args) {
        System.out.println(new SearchInsert_35().searchInsert(new int[]{1},1));
    }

    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
//        if (nums.length == 1) {
//            if (nums[0] >= target) return 0;
//            else return 1;
//        }

        if (target < nums[0]) {
            return 0;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
            if (i < nums.length-1 && nums[i] < target && nums[i+1] > target) {
                return i+1;
            }
        }
        return nums.length;
    }
}
