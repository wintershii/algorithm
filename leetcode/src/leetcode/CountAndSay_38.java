package leetcode;

public class CountAndSay_38 {
    public static void main(String[] args) {
        System.out.println(new CountAndSay_38().countAndSay(5));
    }

    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        } else {
            return nextString(countAndSay(n-1));
        }
    }

    public static String nextString(String s) {
        StringBuilder res = new StringBuilder();
        char[] chars = s.toCharArray();
        int num = 1;
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] != chars[i+1]) {
                res.append(num);
                res.append(chars[i]);
                num = 0;
            }
            num++;
        }
        if (num == 0) {
            res.append(1);
        } else {
            res.append(num);
        }
        res.append(chars[chars.length-1]);
        return res.toString();
    }
}
