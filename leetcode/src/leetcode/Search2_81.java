package leetcode;

public class Search2_81 {

    public boolean search(int[] nums, int target) {
        return binarySearch(nums,target,0,nums.length-1);
    }

    private boolean binarySearch(int[] nums, int target, int left, int right) {
        if (left > right) {
            return false;
        }
        int mid = (left + right) / 2;
        if (nums[mid] == target) {
            return true;
        }
        if (nums[left] < nums[mid]) {
            if (target >= nums[left] && target < nums[mid]) {
                return binarySearch(nums,target,left,mid-1);
            } else {
                return binarySearch(nums,target,mid+1,right);
            }
        } else if (nums[mid] < nums[right]) {
            if (target > nums[mid] && target <= nums[right]) {
                return binarySearch(nums,target,mid+1,right);
            } else {
                return binarySearch(nums,target,left,mid-1);
            }
        } else {
            return binarySearch(nums,target,left,mid-1) || binarySearch(nums,target,mid+1,right);
        }
    }
}
