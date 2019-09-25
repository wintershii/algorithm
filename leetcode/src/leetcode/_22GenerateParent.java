package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _22GenerateParent {
    public static void main(String[] args) {

    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate(result,"",0,0,n);
        return result;
    }

    private void generate(List<String> result, String ans, int p, int q, int n) {
        if (p > n || q > n) {
            return;
        }
        if (p == n && q == n) {
            result.add(ans);
        }
        //最核心的地方 : 只有当左括号数量大于等于右括号时,才继续递归
        if (p >= q) {
            String tmp = new String(ans);
            generate(result,ans + "(",p+1,q,n);
            generate(result,tmp + ")",p,q+1,n);
        }
    }
}
