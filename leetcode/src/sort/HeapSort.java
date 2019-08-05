package sort;

public class HeapSort {

    public static void main(String[] args) {
        int[] arr = new int[]{9,0,1,8,-7,5,6,-2,3,4};
        new HeapSort().heapSort(arr);
        BubbleSort.print(arr);
    }

    public void heapSort(int[] array) {
        //初始化数组为堆
        for (int i = array.length/2; i >= 0; --i) {
            heapAdjust(array,i,array.length);
        }

        for (int i = array.length-1; i > 0; --i) {
            //交换最后一个位置和第一个位置(最大值)
            int tmp = array[0];
            array[0] = array[i];
            array[i] = tmp;

            heapAdjust(array,0,i);
        }
    }

    private void heapAdjust(int[] array, int parent, int length) {
        int tmp = array[parent];
        int child = parent * 2 + 1;
        while (child < length) {
            //如果有右孩子节点, 并且右孩子节点的值大于左孩子节点, 则选取右孩子节点
            if (child + 1 < length && array[child] < array[child+1]) {
                child++;
            }
            //如果父节点的值已经大于孩子节点的值, 则直接结束
            if (tmp >= array[child]) {
                break;
            }
            //给父节点赋值
            array[parent] = array[child];

            //更新parent和child, 继续向下筛选
            parent = child;
            child = 2 * child + 1;
        }
        array[parent] = tmp;
    }
}
