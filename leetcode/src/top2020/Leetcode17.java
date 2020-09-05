package top2020;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 电话号码的组合
 * dfs
 */
public class Leetcode17 {

    List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return res;
        }
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        helper(digits, map, 0, "");
        return res;
    }

    public void helper(String digits, Map<Character, String> map, int index, String str) {
        if (index == digits.length()) {
            res.add(str);
            return;
        }
        String mapping = map.get(digits.charAt(index));
        for (int i = 0; i < mapping.length(); ++i) {
            String tmpstr = str + mapping.charAt(i);
            helper(digits, map, index+1, tmpstr);
        }
    }
}
