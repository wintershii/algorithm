package leetcode;

import java.util.Arrays;

public class _31NextPermutation {
    public static void main(String[] args) {
        int[] nums = new int[]{5,1,1};
        new _31NextPermutation().nextPermutation(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

    public void nextPermutation(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return;
        }
        if (nums.length == 2) {
            swap(nums,0,1);
            return;
        }
        int flag = -1;
        /**
         * 从后往前遍历, 找到第一个前面元素小于后面元素的地方
         */
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] <= nums[i-1]) continue;
            flag = i;
            break;
        }
        if (flag != -1) {
            for (int i = nums.length - 1; i >= 0; i--) {
                if (nums[i] > nums[flag - 1]) {
                    swap(nums,i,flag-1);
                    break;
                }
            }
            reverse(nums,flag);
        }
        else {
            Arrays.sort(nums);
        }

    }

    private void swap(int[] nums, int a, int b) {
        nums[a] = nums[a] ^ nums[b];
        nums[b] = nums[a] ^ nums[b];
        nums[a] = nums[a] ^ nums[b];
    }

    private void reverse(int[] nums, int start) {
        int len = nums.length;
        for (int i = start, count = 0; i < start + (len-start)/2; i++,count++) {
            swap(nums,i,len-count-1);
        }
    }
}
