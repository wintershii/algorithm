package acm.firstweek;

import java.util.Scanner;

public class I_TwoPoint {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int x1 = scan.nextInt();
            int y1 = scan.nextInt();
            int x2 = scan.nextInt();
            int y2 = scan.nextInt();
            double ans = Math.sqrt(Math.abs((double)(x2 - x1)) * Math.abs((double)(x2 - x1)) + Math.abs((double)(y2 - y1)) * Math.abs((double)(y2 - y1)));
            System.out.printf("%.2f\n",ans);
        }
    }
}
