import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int a,b,c;

    }

    public void sall() {
        Scanner scan = new Scanner(System.in);
        int num;

        while ((num = scan.nextInt()) != 0) {
            double res = 0;
            double m = 1;
            double n = 2;
            for (int i = 1; i <= num; ++i) {
                res += n / m;
                double tmp = n;
                n += m;
                m = tmp;
            }
            System.out.printf("%.6f\n",res);
        }
    }
}
