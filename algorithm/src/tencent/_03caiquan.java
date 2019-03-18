package tencent;

import java.util.Scanner;

public class _03caiquan {

    static long ans = 0;

    public static void main(String[] args) {
        int n,s;
        long num = 1000000000;
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        s = scan.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scan.nextInt();
        }
        dfs(s,array,0,0);
        System.out.println(ans);
    }

    public static void dfs(int score,int[] array,int n,int now) {
        if (n == array.length) {
            return;
        }
        if (score == now && n == array.length-1) {
            ans++;
        }

        if (array[n] == 0) {
            dfs(score,array,n+1,now+1);
            dfs(score,array,n+1,now);
            dfs(score,array,n+1,now);
        }
        if (array[n] == 1) {
            dfs(score,array,n+1,now+1);
            dfs(score,array,n+1,now);
            dfs(score,array,n+1,now);
        }
        if (array[n] == 2) {
            dfs(score,array,n+1,now+1);
            dfs(score,array,n+1,now);
            dfs(score,array,n+1,now);
        }

    }

}
