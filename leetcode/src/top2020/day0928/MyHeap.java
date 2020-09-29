package top2020.day0928;

public class MyHeap {

    public static void main(String[] args) {
        System.out.println(new MyHeap().findKthLargest(new int[]{3,2,1,5,6,4}, 2));
    }

    public int findKthLargest(int[] nums, int k) {
        MyHeap heap = new MyHeap();
        for (int i = 0; i < nums.length; ++i) {
            System.out.println(i + " ");
            if (heap.size() < k) {
                heap.add(nums[i]);
            } else {
                if (heap.peek() > nums[i]) {
                    continue;
                } else {
                    heap.poll();
                    heap.add(nums[i]);
                }
            }
        }
        return heap.peek();
    }

    private int[] arr;
    private int size;

    public MyHeap() {
        arr = new int[10000];
        size = 0;
    }

    public int size() {
        return size;
    }

    public Integer peek() {
        if (size == 0) {
            return null;
        }
        return arr[0];
    }

    public Integer poll() {
        if (size == 0) {
            return null;
        }
        int res = arr[0];
        swap(0, size-1);
        size--;
        shiftDown();
        return res;
    }

    public void add(int val) {
        arr[size] = val;
        size++;
        shiftUp();
    }

    private void shiftUp() {
        int child = size - 1;
        int parent = (child - 1) / 2;
        while (child > 0) {
            if (arr[parent] <= arr[child]) {
                break;
            }
            swap(parent, child);
            child = parent;
            parent = (child - 1) / 2;
        }
    }

    private void shiftDown() {
        int parent = 0;
        int child = 2 * parent + 1;
        while (child < size) {
            if (child + 1 < size && arr[child] > arr[child+1]) {
                child++;
            }
            if (arr[parent] <= arr[child]) {
                break;
            }
            swap(parent, child);
            parent = child;
            child = 2 * parent + 1;
        }
    }

    private void swap(int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

}
