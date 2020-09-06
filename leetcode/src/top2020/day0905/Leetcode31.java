package top2020.day0905;

/**
 * 下一个排列
 * 思路：
 * 先逆序找到最右边的升序两个数
 * 然后将开始升序的那个数与从右边数第一个比他大的数进行交换
 * 然后再把刚才开始升序的数位置到最后的数进行逆置
 *
 * 若整个数就是降序的，那就直接逆置整个数组
 */
public class Leetcode31 {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        if (nums.length == 2) {
            swap(nums, 0, 1);
            return;
        }
        int flag = -1;
        for (int i = nums.length - 1; i >= 0; --i) {
            if (nums[i] <= nums[i-1]) {
                continue;
            }
            flag = i;
            break;
        }
        if (flag != -1) {
            for (int i = nums.length - 1; i >= 0; --i) {
                if (nums[i] > nums[flag-1]) {
                    swap(nums, i, flag-1);
                    break;
                }
            }
            reverse(nums, flag);
        } else {
            reverse(nums, 0);
        }
    }

    public void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    public void reverse(int[] arr, int start) {
        int len = arr.length;
        for (int i = start, count = 1; i < (start + len) / 2; ++i, ++count) {
            swap(arr, i, len - count - 1);
        }
    }
}
