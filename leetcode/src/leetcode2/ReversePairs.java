package leetcode2;

/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [7,5,6,4]
 * 输出: 5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReversePairs {

    /**
     * 分治思想，一边归并排序， 一遍记录逆序数量
     * @param nums
     * @return
     */
    public int reversePairs(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return 0;
        }
        int[] tmp = new int[len];
        int res = reversePairs(nums, 0, len-1, tmp);
        return res;
    }

    public int reversePairs(int[] nums, int left, int right, int[] tmp) {
        if (left == right) {
            return 0;
        }
        int mid = (left + right) >> 1;

        int leftCount = reversePairs(nums, left, mid, tmp);
        int rightCount = reversePairs(nums, mid+1, right, tmp);
        int totalCount = leftCount + rightCount;
        if (nums[mid] <= nums[mid+1]) {
            return totalCount;
        }
        int mergeCount = mergeAndCount(nums, left, mid, right, tmp);
        return totalCount + mergeCount;
    }

    public int mergeAndCount(int[] nums, int left, int mid, int right, int[] tmp) {
        for (int i = left; i <= right; ++i) {
            tmp[i] = nums[i];
        }
        int i = left;
        int j = mid + 1;
        int res = 0;
        for (int k = i; k <= right; ++k) {
            if (i > mid) {
                nums[k] = tmp[j];
                j++;
            } else if (j > right) {
                nums[k] = tmp[i];
                i++;
            } else if (tmp[i] <= tmp[j]) {
                nums[k] = tmp[i];
                i++;
            } else {
                nums[k] = tmp[j];
                j++;
                res += mid - i + 1;
            }
        }
        return res;
    }

    /**
     * O(n^2)暴力解题
     * @param nums
     * @return
     */
    public int violence(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; ++i) {
            int tmp = 0;
            for (int j = nums.length - 1; j > i; --j) {
                if (nums[i] > nums[j]) {
                    res++;
                }
            }
        }
        return res;
    }
}
