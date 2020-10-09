package top2020.day1005;

public class Sword40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return new int[]{};
        }
        MyHeap heap = new MyHeap(k);
        for (int i = 0; i < arr.length; ++i) {
            if (heap.size() < k) {
                heap.add(arr[i]);
            } else {
                if (arr[i] < heap.peek()) {
                    heap.poll();
                    heap.add(arr[i]);
                }
            }
        }
        return heap.result();
    }

}

class MyHeap {
    private int[] arr;
    private int size;

    public MyHeap(int capcity) {
        arr = new int[capcity];
        size = 0;
    }

    public void add(int val) {
        arr[size++] = val;
        shiftUp();
    }

    public int poll() {
        if (size == 0) {
            return -1;
        }
        int res = arr[0];
        arr[0] = arr[size-1];
        size--;
        shiftDown();
        return res;
    }

    public int peek() {
        if (size == 0) {
            return -1;
        }
        return arr[0];
    }

    private void shiftUp() {
        int child = size - 1;
        int parent = (child - 1) / 2;
        while (child > 0) {
            if (arr[parent] > arr[child]) {
                break;
            }
            swap(parent, child);
            child = parent;
            parent = (parent - 1) / 2;
        }
    }

    private void shiftDown() {
        int parent = 0;
        int child = 2 * parent + 1;
        while (child < size) {
            if (child + 1 < size && arr[child] < arr[child+1]) {
                child++;
            }
            if (arr[parent] > arr[child]) {
                break;
            }
            swap(parent, child);
            parent = child;
            child = 2 * child + 1;
        }
    }

    private void swap(int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    public int[] result() {
        return arr;
    }

    public int size() {
        return size;
    }
}
