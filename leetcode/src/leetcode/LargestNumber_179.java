package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber_179 {

    public static void main(String[] args) {
        System.out.println(new LargestNumber_179().largestNumber(new int[]{3,30,34,5,9}));
    }


    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            strs[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1 = o1 + o2;
                String s2 = o2 + o1;
                return s2.compareTo(s1);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; ++i) {
            sb.append(strs[i]);
        }
        if (sb.toString().charAt(0) == '0') {
            return "0";
        }
        return sb.toString();
    }
}
