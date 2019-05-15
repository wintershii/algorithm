package leetcode;

public class AddBinary_67 {
    public String addBinary(String a, String b) {
        if (a == null || a.length() == 0) return b;
        if (b == null || b.length() == 0) return a;

        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;

        int c = 0;
        while (i >= 0 || j >= 0) {
            if (i >= 0) c += a.charAt(i--) - '0';
            if (j >= 0) c += b.charAt(j--) - '0';
            sb.append(c % 2);
            c >>= 1;
        }
        String res = sb.reverse().toString();
        return c > 0 ? '1'+res : res;
    }
}
