package _2digui;

import java.util.ArrayList;
import java.util.List;

/**
 * 生成括号
 * 输入一个数字n, 表示括号对数
 * 输出所有合法的括号
 */
public class _4LegelKuohao {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate(result,"",0,0,n);
        return result;
    }

    /**
     * 思想 : 递归过程中通过条件 : 右括号数不能大于左括号数, 进行筛选
     * @param list
     * @param str
     * @param left
     * @param right
     * @param n
     */
    public void generate(List<String> list, String str, int left, int right, int n) {
        if (right > left || left > n || right > n) {
            return;
        }
        if (left == n && right == n) {
            list.add(str);
        }
        generate(list, str + '(', left+1, right, n);
        generate(list,str+')',left,right+1,n);
    }
}
