import java.util.Arrays;
import java.util.Scanner;

/**
 * 递增三元组
 */
public class IncreaseThreeArray {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] a = new int[100000];
        int[] b = new int[100000];
        int[] c = new int[100000];
        for (int i = 0; i < n; i++) {
            a[i] = scan.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = scan.nextInt();
        }
        for (int i = 0; i < n; i++) {
            c[i] = scan.nextInt();
        }

        int ans = better(n,a,b,c);
        //int ans = violence(n,a,b,c);
        System.out.println(ans);
    }

    /**
     * 自己写的暴力解法
     */
    public static int violence(int n, int[] a, int[] b, int[] c) {
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (a[i] < b[j] && b[j] < c[k]) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }

    /**
     *找到的其他方法
     */
    public static int better(int n, int[] a, int[] b, int[] c) {
        Arrays.sort(a,0,n -1 );
        Arrays.sort(b,0,n -1 );
        Arrays.sort(c,0,n -1 );
        int time = 1;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int tmp = b[i];
            int x1 = 0;
            int x2 = 0;
            int o1 = 0;
            int o2 = 0;
            for (int j = o1; j < n; j++) {
                if (tmp > a[j]) {
                    x1++;
                    o1++;
                    continue;
                }
                break;
            }
            if (i > 0) {
                x1 += o1;
            }
            for (int j = o2; j < n; j++) {
                if (tmp > c[j]) {
                    x2++;
                    o2++;
                    continue;
                }
                break;
            }
            if (i > 0) {
                x2 += o2;
            }
            x2 = n - x2;
            time = x1 * x2;

            ans += time;
        }
        return ans;
    }
}
