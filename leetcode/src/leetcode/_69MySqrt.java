package leetcode;

public class _69MySqrt {
    public static void main(String[] args) {
        System.out.println(new _69MySqrt().mySqrt(100));
    }

    /**
     * 解法 :
     * 二分法
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        if (x == 1) return x;
        int min = 0;
        int max = x;
        while (max > min+1) {
            int tmp = (max + min) / 2;
            if (x / tmp < tmp) {
                max = tmp;
            } else {
                min = tmp;
            }
        }
        return min;
    }
}
