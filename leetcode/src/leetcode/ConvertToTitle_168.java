package leetcode;

public class ConvertToTitle_168 {
    public static void main(String[] args) {
        System.out.println(new ConvertToTitle_168().convertToTitle(1));
    }

    public String convertToTitle(int n) {
        if (n < 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            n--;
            sb.append((char)('A' + n % 26));
            n /= 26;
        }
        return sb.reverse().toString();
    }
}
