package top2020.day0905;

public class Leetcode8 {
    public int myAtoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        str = str.trim();
        if (str.length() == 0) {
            return 0;
        }
        boolean pos = false;
        boolean neg = false;
        if (str.charAt(0) != '-' && str.charAt(0) != '+') {
            if (str.charAt(0) < '0' || str.charAt(0) > '9') {
                return 0;
            }
        } else {
            if (str.charAt(0) == '-') {
                neg = true;
            }
            if (str.charAt(0) == '+') {
                pos = true;
            }
        }
        long res = 0;
        for (int i = 0; i < str.length(); ++i) {
            if (i == 0 && (pos || neg)) {
                continue;
            }
            if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                break;
            }
            res = res * 10 + str.charAt(i) - '0';
            if (neg && -res < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            if (!neg && res > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
        }
        return neg ? (int)-res : (int) res;
    }
}
