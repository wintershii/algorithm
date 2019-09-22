package _6stack;

import java.util.PriorityQueue;

/**
 * 第K大的数
 * 使用大小为k的最小堆,并维护
 */
public class _2KNum {
    /**
     * 遍历数组,当最小堆大小小于k时,新元素直接添加
     * 当新元素小于堆顶元素时,略过
     * 当新元素大于堆顶元素时,将堆顶剔除,新元素入堆并调整
     * 最终返回堆顶元素即可
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i = 0; i < nums.length; ++i) {
            if (heap.size() < k) {
                heap.offer(nums[i]);
            } else {
                if (nums[i] < heap.peek()) {
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
            int index = partition(nums,left,right);
            if (index == target) {
                return nums[target];
            } else if (index < target) {
                left = index + 1;
            } else {
                right = index - 1;
            }
        }
    }


    private int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        while (left < right) {
            while (left < right && nums[right] >= pivot)
                right--;
            nums[left] = nums[right];
            while (left < right && nums[left] <= pivot)
                left++;
            nums[right] = nums[left];
        }
        nums[left] = pivot;
        return left;

//        int pivot = nums[left];
//        int j = left;
//        for (int i = left + 1; i <= right; i++) {
//            if (nums[i] < pivot) {
//                // 小于 pivot 的元素都被交换到前面
//                j++;
//                swap(nums, j, i);
//            }
//        }
//        // 最后这一步不要忘记了
//        swap(nums, j, left);
//        return j;

    }
    private void swap(int[] nums, int index1, int index2) {
        if (index1 == index2) {
            return;
        }
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
