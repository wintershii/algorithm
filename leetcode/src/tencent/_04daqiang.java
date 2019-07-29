package tencent;

import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class _04daqiang {
    public static void main(String[] args) {
        int n,m;
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();

        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scan.nextInt();
        }

        System.out.println(slideWindow(array,m));
    }

    public static int slideWindow(int[] array,int m) {
        int length = array.length;
        Set set = new HashSet<>();
        int ans = 999999999;
        int i = 0, j = 0;
        while (i < length && j < length) {
            if (array[j] == 0) {
                j++;
            }
            if (set.size() == m) {
                ans = Math.min(ans,j - i);
                System.out.println("i:" + i +" "+ array[i] + "  j:"+ j  + " "+ array[j]);
                set.clear();
                i = j;
            }
            if (!set.contains(array[j])){
                set.add(array[j++]);
            } else {
                if (array[i] == array[j]) {
                    i++;
                }
                j++;
            }
        }
        return ans;
    }
}
