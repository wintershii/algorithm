package top2020;

import java.util.ArrayList;
import java.util.List;

public class Leetcode22 {

    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        if (n == 0) {
            return res;
        }
        helper(0, 0, n, "");
        return res;
    }

    public void helper(int left, int right, int n, String str) {
        if (left > n || right > n || right > left) {
            return;
        }
        if (left == right && left == n) {
            res.add(str);
            return;
        }
        helper(left+1, right, n, str + '(');
        helper(left, right+1, n, str + ')');
    }
}
