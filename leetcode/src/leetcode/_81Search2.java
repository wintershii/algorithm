package leetcode;

/**
 * 二分查找
 */
public class _81Search2 {

    public boolean search(int[] nums, int target) {
        return binarySearch(nums,target,0,nums.length-1);
    }

    /**
     * 递归的写法
     * @param nums
     * @param target
     * @param left
     * @param right
     * @return
     */
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


    /**
     * 迭代进行
     * @param nums
     * @param target
     * @return
     */
    public boolean search2(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            while (left < right && nums[left] == nums[left + 1])
                left++;
            while (left < right && nums[right] == nums[right - 1])
                right--;
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[left] <= nums[mid]) {
                if (target >= nums[left] && target <= nums[mid])
                    right = mid - 1;
                else
                    left = mid + 1;
            } else {
                if (target >= nums[mid] && target <= nums[right])
                    left = mid + 1;
                else
                    right = mid - 1;
            }
        }
        return false;
    }

}
