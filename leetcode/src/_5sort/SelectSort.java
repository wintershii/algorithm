package _5sort;

public class SelectSort {

    public static void main(String[] args) {
        int[] arr = new int[]{9,0,1,8,-7,5,6,-2,3,4};
        new ShellSort().shellSort(arr);
        BubbleSort.print(arr);
    }

    public void selectSort(int[] array) {
        for (int i = 0; i < array.length - 1; ++i) {
            int min = i;
            for (int j = i + 1; j < array.length; ++j) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            if (min != i) {
                int tmp = array[i];
                array[i] = array[min];
                array[min] = tmp;
            }
        }
    }
}
