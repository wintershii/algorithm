package stack;

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
}
