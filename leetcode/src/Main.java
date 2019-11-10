import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int w1,h1,w2,h2;
        while (scan.hasNext()) {
            w1 = scan.nextInt();
            h1 = scan.nextInt();
            w2 = scan.nextInt();
            h2 = scan.nextInt();
            int p1 = (w1 + h1) * 2;
            int a1 = w1 * h1;
            int p2 = (w2 + h2) * 2;
            int a2 = w2 * h2;
            boolean equ = false;
            if ((w1 == w2 && h1 == h2) || (w1 == h2) && (w2 == h1)) {
                equ = true;
            }
            System.out.printf("Rectangle(%d,%d):Perimeter=    %d\tArea=   %d\tRectangle(%d,%d):Perimeter=   %d\tArea=  %d\tEquals=%b\n",
                    w1,h1,p1,a1,w2,h2,p2,a2,equ);
        }
    }

//    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        double x1, x2, y1, y2;
//        while (scan.hasNext()) {
//            x1 = scan.nextDouble();
//            y1 = scan.nextDouble();
//            x2 = scan.nextDouble();
//            y2 = scan.nextDouble();
//            boolean horzion = false, vertical = false;
//            double slope = 0.00;
//            if (y2 == y1) {
//                horzion = true;
//                slope = 0.00;
//            }
//            if (x2 == x1) {
//                vertical = true;
//                slope = Double.NaN;
//            }
//
//            if (x2 != x1 && y2 != y1) {
//                slope = (y2 - y1) / (x2 - x1);
//            }
//            double length = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
//            System.out.printf("Lenght=%.2f\tIs Horizontal=%b\tIs Vertical=%b\tSlope=%.2f\tMidPoint=(%.2f,%.2f)", length,
//                    horzion, vertical, slope,(x2-x1)/2,(y2-y1)/2);
//        }
//
//    }

}
