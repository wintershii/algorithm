package top2020;

/**
 * 搜索旋转数组
 * 二分
 */
public class Leetcode33 {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] == target) return mid;
            if (nums[mid] == nums[left]) {
                left++;
            } else if (nums[mid] > nums[left]) {
                //左边有序
                if (nums[mid] > target && nums[left] <= target)
                    right = mid - 1;
                else
                    left = mid + 1;
            } else {
                //右边有序
                if (nums[mid] < target && nums[right] >= target)
                    left = mid + 1;
                else
                    right = mid - 1;
            }
        }
        return -1;
    }
}
