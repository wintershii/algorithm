package _1binaryfind;

/**
 * 搜索在随机位置翻转后的目标值的位置
 */
public class _4SearchInverseArray {

    public static void main(String[] args) {
        System.out.println(new _4SearchInverseArray().search(new int[]{4,5,6,7,0,1,2},2));
    }


    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[left] == nums[mid]) {
                left++;
            } else if (nums[left] < nums[mid]) {
                if (target >= nums[left] && target < nums[mid]) right = mid - 1;
                else left = mid + 1;
            } else {
                if (target <= nums[right] && target > nums[mid]) left = mid + 1;
                else right = mid - 1;
            }
        }
        return -1;
    }
}
