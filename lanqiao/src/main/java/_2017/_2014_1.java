package _2017;

/**
 * 纸牌三角形
 *
 * A,2,3,4,5,6,7,8,9共九张牌排成一个正三角形 A 按1计算 要求每个边的和相等
 *
 * 如果考虑旋转,镜像后相同的算同一种,一共有多少汇总不同的排法
 *
 *   A 0
 *  9 1 6 2
 * 4 3   8 4
 *3 5 7 6 5 7 2 8
 *
 * 全排列问题 (模板)
 */
public class _2014_1 {
    static int[] a = {1,2,3,4,5,6,7,8,9};
    static int ans;

    public static void main(String[] args) {
        f(0);
        System.out.println(ans/6);
    }


    static void f(int k) {
        if (k == 9) {
            int x1 = a[0] + a[1] + a[3] + a[5];
            int x2 = a[0] + a[2] + a[4] + a[8];
            int x3 = a[5] + a[6] + a[7] + a[8];
            if (x1 == x2 && x2 == x3) {
                ans++;
            }
        }
        for (int i = k; i < 9; i++){
            int t = a[k];
            a[k] = a[i];
            a[i] = t;
            f(k + 1);
            t = a[k];
            a[k] = a[i];
            a[i] = t;

        }

    }

}
