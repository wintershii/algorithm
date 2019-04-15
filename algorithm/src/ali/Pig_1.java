package ali;

import java.util.List;
import java.util.Scanner;

public class Pig_1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt();
        int k = scan.nextInt();
        System.out.println(new Pig_1().getYear(m));
    }

    private void solve(int m, int k) {
        int origin = 2;
        System.out.println(getYear(m));
    }


    private int getM(int m) {
        if (m == 1) {
            return 2;
        }
        if (m == 2) {
            return 3;
        }
        return getM(m - 2) + getM(m - 3);
    }


    private int getYear(int m) {
        if (m == 1 || m == 2) {
            return 2019;
        }
        for (int i = 2019; ; i++) {
            if (doIt(i) > m) {
                return i;
            }
        }
    }

    private int doIt(int year) {
        if (year == 2019) {
            return 2;
        }
        if (year == 2020) {
            return 3;
        }
        return doIt(year - 1) + doIt(year - 2);
    }
}
