package shopee;
import java.util.Scanner;

public class One {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            String str = in.nextLine();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < str.length(); ++i) {
                if (!Character.isLetter(str.charAt(i)) && !Character.isDigit(str.charAt(i))) {
                    continue;
                }
                if (sb.length() == 0) {
                    sb.append(Character.toLowerCase(str.charAt(i)));
                } else if (!Character.isDigit(str.charAt(i-1)) && !Character.isLetter(str.charAt(i-1))) {
                    sb.append(Character.toUpperCase(str.charAt(i)));
                } else {
                    sb.append(Character.toLowerCase(str.charAt(i)));
                }
            }
            System.out.println(sb.toString());
        }
}
