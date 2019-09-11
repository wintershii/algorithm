import java.util.Scanner;


public class _2Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        StringBuilder res = new StringBuilder();
        boolean book = false;
        for (int i = 1; i <= n; ++i) {
            if ((i & 1) == 1) {
                res.append('A');
            } else {
                if (!book) {
                    book = true;
                    res.append('B');
                } else {
                    book = false;
                    res.append('C');
                }
            }
        }
        System.out.println(res.toString());
    }
}
