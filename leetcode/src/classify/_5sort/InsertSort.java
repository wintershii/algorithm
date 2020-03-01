package classify._5sort;

public class InsertSort {

    public static void main(String[] args) {
        int[] arr = new int[]{9,0,1,8,-7,5,6,-2,3,4};
        new InsertSort().insertSort(arr);
        BubbleSort.print(arr);
    }

    public void insertSort(int[] array) {
        for (int i = 1; i < array.length; ++i) {
            int j = 0;
            int tmp = array[i];
            for (j = i-1; j >=0 && tmp < array[j]; --j) {
                array[j+1] = array[j];
            }
            array[j+1] = tmp;
        }
    }

}
