package leetcode;

public class MySqrt_69 {
    public static void main(String[] args) {
        System.out.println(new MySqrt_69().mySqrt(100));
    }

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
