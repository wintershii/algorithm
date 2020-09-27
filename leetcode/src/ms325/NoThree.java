package ms325;

import java.util.ArrayList;
import java.util.Arrays;

public class NoThree {
    public static void main(String[] args) {
        int[] arr = new int[]{11,7,5,10,46,23,16,8};
        new NoThree().solve(arr, 3);
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public void solve(int[] arr, int k) {
        int[] arr1 = new int[k];
        Integer[] arr2 = new Integer[arr.length - k];
        int index = 0;
        for (int i = 0; i < k; ++i) {
            arr1[i] = arr[index++];
        }
        for (int i = 0; i < arr2.length; ++i) {
            arr2[i] = arr[index++];
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2, (o1,o2) -> o2-o1);
        index = 0;
        for (int i = 0; i < k; ++i) {
            arr[index++] = arr1[i];
        }
        for (int i = 0; i < arr2.length; ++i) {
            arr[index++] = arr2[i];
        }
    }
}
