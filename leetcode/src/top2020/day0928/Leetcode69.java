package top2020.day0928;

public class Leetcode69 {
    public int mySqrt(int x) {
        int min = 0;
        int max = x;
        while (max > min) {
            int mid = (max + min) >> 1;
            if (max / mid < mid) {
                max = mid;
            } else {
                min = mid;
            }
        }
        return min;
    }
}
