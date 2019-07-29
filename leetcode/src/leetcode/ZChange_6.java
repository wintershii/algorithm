package leetcode;

import java.util.ArrayList;
import java.util.List;

public class ZChange_6 {


    public static void main(String[] args) {
        System.out.println(new ZChange_6().convert("AB",1));
    }

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        List<StringBuilder> list = new ArrayList<>();
        int num = 0;
        boolean flag = false;

        for (int i = 0; i < Math.min(s.length(),numRows); i++) {
            list.add(new StringBuilder());
        }

        for (char c : s.toCharArray()) {
            list.get(num).append(c);
            if (num == 0 || num == numRows - 1) {
                flag = !flag;
            }
            num += flag ? 1 : -1;
        }
        StringBuilder ans = new StringBuilder();
        for (StringBuilder builder : list) {
            ans.append(builder);
        }
        return ans.toString();
    }
}
