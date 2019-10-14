package leetcode;


/**
 * 加一
 */
public class _66PlusOne {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        digits[len-1] += 1;
        for (int i = len-1; i >= 0; i--) {
            if (digits[i] >= 10) {
                if (i-1 >= 0) {
                    digits[i-1] += 1;
                    digits[i] %= 10;
                } else {
                    digits[i] %= 10;
                    int[] arr = new int[len+1];
                    arr[0] = 1;
                    System.arraycopy(digits, 0, arr, 1, len);
                    digits = arr;
                }

            }
        }
        return digits;
    }
}
