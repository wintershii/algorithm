package leetcode;

public class _70ClimbStairs {
    public static void main(String[] args) {
        System.out.println(new _70ClimbStairs().climbStairs(3));
    }

    public int climbStairs(int n) {
        if (n == 1)
            return 1;
        int x = 1;
        int y = 2;
        for (int i = 0; i < n-2; i++) {
            int tmp = x + y;
            x = y;
            y = tmp;
        }
        return y;
    }



    public int violence(int n) {
        return solve(n);
    }

    public int solve(int n) {
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        else
            return solve(n-1) + solve(n-2);
    }
}
