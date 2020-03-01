package classify._1binaryfind;

/**
 * 二分查找
 *
 */
public class _1BinarySearch {

    public static void main(String[] args) {
        System.out.println(new _1BinarySearch().binarySearch2(new int[]{1,4,7,11,20}, 11));
    }

    /**
     * 递归形式
     * @param nums
     * @param target
     * @return
     */
    public boolean binarySearch(int[] nums, int begin, int end, int target) {
        if (begin > end) {
            return false;
        }
        int mid = (end + begin) / 2;
        if (target == nums[mid]) {
            return true;
        } else if (target < nums[mid]) {
            return binarySearch(nums,begin,mid-1,target);
        } else {
            return binarySearch(nums,mid+1,end,target);
        }
    }


    /**
     * 非递归形式
     */
    public boolean binarySearch2(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (right + left) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}
