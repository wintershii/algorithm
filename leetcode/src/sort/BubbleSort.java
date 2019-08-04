package sort;

public class BubbleSort {
    public void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 2; ++i) {
            boolean flag = false;
            for (int j = n -1; j >=i ; --j) {
                if (array[j] < array[j-1]) {
                    int tmp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = tmp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
    }
}
