package binaryfind;

/**
 * 查找区间
 * 给定一个排序数组(有重复元素)和目标值target, 如果target在nums里出现, 则返回target所在区间的左右端点下标
 * 如果target在nums里出现,则返回[-1,-1]
 */
public class _3SearchRange {

    public static void main(String[] args) {

    }


    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int a = -1, b = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target == nums[mid]) {
                a = mid;
                b = mid;
                while (a > 0 && nums[a-1] == target) {
                    a--;
                }
                while (b < nums.length - 1 && nums[b+1] == target) {
                    b++;
                }
                break;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return new int[]{a,b};
    }
}
