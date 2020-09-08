package top2020.day0908;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 最大数
 * 输入: [10,2]
 * 输出: 210
 */
public class Leetcode179 {
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
        for (int i = 0; i < strs.length; ++i) {
            sb.append(strs[i]);
        }
        if (sb.toString().charAt(0) == '0') {
            return "0";
        }
        return sb.toString();
    }
}
