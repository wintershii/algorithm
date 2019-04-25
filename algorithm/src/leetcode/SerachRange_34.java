package leetcode;

public class SerachRange_34 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,3};
        int[] res = new SerachRange_34().searchRange(nums,1);
        for (int i = 0; i < 2; i++) {
            System.out.print(res[i] + " ");
        }
    }

    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1,-1};
        }
        int left = 0;
        int right = nums.length;

        int a = -1;
        int b = -1;

        while (right >= left) {
            int mid = (left + right) / 2;
            if (mid < 0 || mid > nums.length-1) {
                break;
            }
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] == target){
                a = mid;
                b = mid;
                while (a > 0 && nums[a-1] == nums[a]) a--;
                while (b < nums.length-1 && nums[b+1] == nums[b]) b++;
                break;
            }
        }
        return new int[]{a,b};
    }
}
