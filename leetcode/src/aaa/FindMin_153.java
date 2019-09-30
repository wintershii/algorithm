package aaa;

import java.util.LinkedList;
import java.util.Timer;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 请找出其中最小的元素。
 *
 * 你可以假设数组中不存在重复元素。
 *
 * 示例 1:
 *
 * 输入: [3,4,5,1,2]
 * 输出: 1
 * 示例 2:
 *
 * 输入: [4,5,6,7,0,1,2]
 * 输出: 0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindMin_153 {

    public static void main(String[] args) {
        System.out.println(new FindMin_153().findMin(new int[]{4,5,6,7,0,1,2}));
    }

    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        if (nums[right] > nums[left])
            return nums[0];
        while (left < right && right - left > 1) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return Math.min(nums[left],nums[right]);
    }
}
