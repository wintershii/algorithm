package classify.string;

public class MultiplyString {
    public static void main(String[] args) {
        System.out.println(new MultiplyString().multiply("2","3"));
    }

    public String multiply(String num1, String num2) {
        int n1 = num1.length();
        int n2 = num2.length();
        int[] array1 = new int[n1];
        int[] array2 = new int[n2];

        int[] num = new int[n1 + n2];

        for (int i = 0; i < n1; i++) {
            array1[i] = num1.charAt(i) - '0';
        }
        for (int i = 0; i < n2; i++) {
            array2[i] = num2.charAt(i) - '0';
        }

        int i,j,k;

        for (i = 0; i < n2; i++) {
            int carry = 0;
            for (j = 0; j < n1; j++) {
                num[i + j] += array2[n2-i-1] * array1[n1-j-1] + carry;
                carry = num[i+j] / 10;
                num[i + j] %= 10;
            }

            k = i + j;
            while (carry != 0) {
                num[k] += carry;
                carry = num[k] / 10;
                num[k] %= 10;
                k++;
            }
        }

        StringBuilder sb = new StringBuilder(n1+n2);
        i = n1 + n2 -1;
        while (i > 0 && num[i] == 0) {
            i--;
        }
        while (i >= 0) {
            sb.append(num[i--]);
        }
        return sb.toString();

    }


}
