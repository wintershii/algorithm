package classify._5sort;

public class ShellSort {

    public static void main(String[] args) {
        int[] arr = new int[]{9,0,1,8,-7,5,6,-2,3,4};
        new ShellSort().shellSort(arr);
        BubbleSort.print(arr);
    }

    public void shellSort(int[] array) {
        int gap = array.length / 2;
        while (1 <= gap) {
            for (int i = gap; i < array.length; ++i) {
                int j = 0;
                int tmp = array[i];
                for (j = i - gap; j >= 0 && tmp < array[j]; j -= gap) {
                    array[j + gap] = array[j];
                }
                array[j + gap] = tmp;
            }
            gap = gap / 2;
        }
    }
}
