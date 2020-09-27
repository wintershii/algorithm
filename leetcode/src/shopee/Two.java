package shopee;

import java.util.Scanner;

public class Two {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        int[] value = new int[str.length()];
        for (int i = 0; i < str.length(); ++i) {
            value[i] = str.charAt(i) - '0';
        }
        int index = -1;
        for (int i = value.length - 1; i > 0; --i) {
            if (value[i] >= value[i-1]) {
                continue;
            }
            index = i;
            break;
        }

        if (index == -1) {
            System.out.println(0);
            return;
        }
        int max = value.length;
        for (int i = value.length-1; i >index-1 ; --i) {
            if (value[i] < value[index-1]) {
                if (max == value.length) {
                    max = i;
                } else {
                    if (value[i] > value[max]) {
                        max = i;
                    }
                }

            }
        }
        swap(value, index - 1, max);
        StringBuilder sb2 = new StringBuilder();
        for (int i = index; i < value.length; ++i) {
            sb2.append(value[i]);
        }
        sb2.reverse();
        for (int i = 0; i < sb2.length(); ++i) { ;
            value[index+i] = sb2.charAt(i) - '0';
        }
        if (value[0] == 0) {
            System.out.println(0);
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i : value) {
            sb.append(i);
        }
        System.out.println(sb.toString());
    }


    public static void swap(int[] value, int i, int j) {
        int tmp = value[i];
        value[i] = value[j];
        value[j] = tmp;
    }
}
