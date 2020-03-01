package classify._1binaryfind;

/**
 * 插入位置
 * 给定一个排序数组nums(无重复元素元素)与目标值target, 如果在target中出现, 则返回其所在下标
 * 如果target中未出现, 则返回应该插入位置的数组下标
 */
public class _2SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int index = -1;
        while (index == -1) {
            int mid = (left + right) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target < nums[mid]) {
                if (mid == 0 || target > nums[mid - 1]) {
                    return mid;
                }
                right = mid - 1;
            } else {
                if (mid == nums.length - 1 || target < nums[mid + 1]) {
                    return mid + 1;
                }
                left = mid + 1;
            }
        }
        return index;
    }
}
