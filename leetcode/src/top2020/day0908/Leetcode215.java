package top2020.day0908;

import java.util.PriorityQueue;

/**
 * 第K大的元素
 * 1.排序取倒数第k个，O(nlogn)
 * 2.最小堆 O(nlogk)
 * 3.快排思想 O(n)
 */
public class Leetcode215 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i = 0; i < nums.length; ++i) {
            if (heap.size() < k) {
                heap.offer(nums[i]);
            } else {
                if (heap.peek() > nums[i]) {
                    continue;
                } else {
                    heap.poll();
                    heap.offer(nums[i]);
                }
            }
        }
        return heap.peek();
    }

    public int findKthLargest2(int[] nums, int k) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        int target = len - k;
        while (true) {
            int index = division(nums, left, right);
            if (index == target) {
                return nums[target];
            } else if (index < target) {
                left = index + 1;
            } else  {
                right = index - 1;
            }
        }
    }

    public int division(int[] nums, int left, int right) {
        int base = nums[left];
        while (left < right) {
            while (left < right && nums[right] >= base)
                right--;
            nums[left] = nums[right];
            while (left < right && nums[left] <= base)
                left++;
            nums[right] = nums[left];
        }
        nums[left] = base;
        return left;
    }
}
