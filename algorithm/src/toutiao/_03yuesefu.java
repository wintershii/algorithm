package toutiao;

import java.util.Scanner;

public class _03yuesefu {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        while (n-- != 0) {
            int num = scan.nextInt();
            int[] arr = new int[num];
            for (int i = 0; i < num; i++) {
                arr[i] = scan.nextInt();
            }
            int gift = solve(arr);
        }
    }


    public static int solve(int[] arr) {
        int[] price = new int[arr.length];
        int low = findLowest(arr);
        price[low] = 1;
        for (int i = low + 1; i < arr.length; i++) {
            if (arr[i] > arr[i-1]) {
                price[i] = price[i-1] + 1;
                if (arr[i+1] > arr[i]) {
                    price[i+1] = price[i] + 1;
                }
            }
        }

    }

    public static int findLowest(int[] arr) {
        int low = 0;
        for (int i = 0; i < arr.length; i++) {
            if (low > arr[i]) {
                low = i;
            }
        }
        return low;
    }
}
