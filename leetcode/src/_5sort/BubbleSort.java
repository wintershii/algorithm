package _5sort;

public class BubbleSort {


    public static void main(String[] args) {
        int[] arr = new int[]{9,0,1,8,-7,5,6,-2,3,4};
        new BubbleSort().bubbleSort(arr);
        print(arr);
    }


    public void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; ++i) {
            boolean flag = false;
            for (int j = n -1; j > i ; --j) {
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

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}
