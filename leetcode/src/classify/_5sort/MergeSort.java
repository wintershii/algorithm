package classify._5sort;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = new int[]{9,0,1,8,-7,5,6,-2,3,4,-100};
        new MergeSort().mergeSort(arr);
        BubbleSort.print(arr);
    }

    //归并排序入口
    public void mergeSort(int[] array) {
        //
        for (int gap = 1; gap <= array.length; gap *= 2) {
            mergePass(array, gap, array.length);
        }
    }

    private void mergePass(int[] array, int gap, int length) {
        int i = 0;

        //归并gap长度的两个相邻子表
        for (i = 0; i + 2*gap - 1 < length; i += 2*gap) {
            merge(array, i, i + gap -1, i + 2 * gap - 1);
        }

        //剩余两个子表, 后者长度小于gap
        if (i + gap - 1 < length) {
            merge(array, i, i + gap - 1, length - 1);
        }

    }

    private void merge(int[] array, int left, int mid, int right) {
        //第一个数组中的指针
        int i = left;
        //第二个数组中的指针
        int j = mid + 1;
        //新开辟数组的指针
        int k = 0;
        int[] array2 = new int[right-left+1];

        while (i <= mid && j <= right) {
            if (array[i] <= array[j]) {
                array2[k++] = array[i++];
            } else {
                array2[k++] = array[j++];
            }
        }
        while (i <= mid) {
            array2[k++] = array[i++];
        }

        while (j <= right) {
            array2[k++] = array[j++];
        }

        for (k = 0, i = left; i <= right; ++i,++k) {
            array[i] = array2[k];
        }
    }
}
