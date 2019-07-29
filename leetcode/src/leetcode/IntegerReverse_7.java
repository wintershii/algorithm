package leetcode;

public class IntegerReverse_7 {

    public static void main(String[] args) {
        System.out.println(new IntegerReverse_7().reverse(-123));
    }

    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (Math.abs(res) > Integer.MAX_VALUE / 10) {
                return 0;
            }
            res = res * 10 + pop;
        }
        return res;
    }
}
