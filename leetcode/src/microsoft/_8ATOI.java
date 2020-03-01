package microsoft;

/**
 * 8. 字符串转换整数 (atoi)
 */
public class _8ATOI {

    public static void main(String[] args) {
        System.out.println(new _8ATOI().myAtoi("-2147483648"));
    }

    public int myAtoi(String str) {
        if (str.equals("")) {
            return 0;
        }
        boolean neg = false;
        boolean pos = false;
        int count = 0;
        for (int i = 0; i < str.length(); ++i) {
            if (str.charAt(i) == ' ') {
                count++;
            } else {
                break;
            }
        }
        str = str.substring(count);

        if (str.equals("")) {
            return 0;
        }
        if (str.charAt(0) != '-' && str.charAt(0) != '+') {
            if (str.charAt(0) < '0' || str.charAt(0) > '9') {
                return 0;
            }
        } else {
            if (str.charAt(0) == '-') {
                neg = true;
            }
            if (str.charAt(0) == '+') {
                pos = true;
            }
        }

        long res = 0;
        for (int i = 0; i < str.length(); ++i) {
            if (i == 0 && (neg || pos)) {
                continue;
            }
            if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                break;
            }
            res = res * 10 + (str.charAt(i) - '0');
            if (neg && -res < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            if (!neg && res > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
        }
        return neg ? (int)-res : (int)res;
    }
}
