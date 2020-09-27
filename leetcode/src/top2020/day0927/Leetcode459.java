package top2020.day0927;

public class Leetcode459 {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        for (int l = n / 2; l >= 1; --l) {
            if (n % l != 0) {
                continue;
            }
            boolean flag = true;
            for (int j = n-1; j >= l; --j) {
                if (s.charAt(j) != s.charAt(j-l)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return true;
            }
        }
        return false;
    }
}
