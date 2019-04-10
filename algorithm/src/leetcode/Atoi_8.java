package leetcode;

public class Atoi_8 {
    public static void main(String[] args) {
        System.out.println(new Atoi_8().myAtoi("+1"));
    }

    public int myAtoi(String str) {
        StringBuilder builder = new StringBuilder();
        str = str.trim();
        if (str.isEmpty()) {
            return 0;
        }
        if (str.length() == 1 && str.charAt(0) == '-') {
            return 0;
        }
        if (checkHead(str.charAt(0))) {
            builder.append(str.charAt(0));
            for (int i = 1; i < str.length(); i++) {
                if (check(str.charAt(i))) {
                    builder.append(str.charAt(i));
                } else if(str.charAt(i) == ' '){
                    continue;
                } else {
                    break;
                }
            }
            String ans = builder.toString();
            if (ans.isEmpty()) {
                return 0;
            }
            if (ans.length() == 1 && (ans.charAt(0) == '-' || ans.charAt(0) == '+')) {
                return 0;
            }
            if (ans.charAt(0) == '+') {
                ans = ans.substring(1);
            }


            if (ans.length() >= 10 && ans.charAt(0) != '-' && ans.charAt(0) > 2 ) {
                return Integer.MAX_VALUE;
            }
            if (ans.length() >= 10 && ans.charAt(0) == '-' && ans.charAt(1) > 2 ) {
                return Integer.MIN_VALUE;
            }

            long res = Integer.parseInt(ans);
            return (int)res;
        }
        return 0;
    }


    private boolean checkHead(char c) {
        if (c == '0' || c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8' ||
                c == '9' || c == '-' || c == '+') {
            return true;
        }
        return false;
    }

    private boolean check(char c) {
        if (c == '0' || c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8' ||
                c == '9') {
            return true;
        }
        return false;
    }

}
