package aaa;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 根据逆波兰表示法，求表达式的值。
 *
 * 有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 *
 * 说明：
 *
 * 整数除法只保留整数部分。
 * 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 * 示例 1：
 *
 * 输入: ["2", "1", "+", "3", "*"]
 * 输出: 9
 * 解释: ((2 + 1) * 3) = 9
 * 示例 2：
 *
 * 输入: ["4", "13", "5", "/", "+"]
 * 输出: 6
 * 解释: (4 + (13 / 5)) = 6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/evaluate-reverse-polish-notation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class EvalRPN_150 {

    public static void main(String[] args) {
        System.out.println(new EvalRPN_150().evalRPN(new String[]{"4", "13", "5", "/", "+"}));
    }

    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String str : tokens) {
            if (isSymbol(str)) {
                int top = stack.pop();
                int second = stack.pop();
                int result = 0;
                switch(str) {
                    case "+" : result = second + top; break;
                    case "-" : result = second - top; break;
                    case "*" : result = second * top; break;
                    case "/" : result = second / top; break;
                }
                stack.push(result);
            } else {
                stack.push(Integer.parseInt(str));
            }
        }
        return stack.pop();
    }

    private boolean isSymbol(String str) {
        if ("+".equals(str) || "-".equals(str) || "*".equals(str) || "/".equals(str)) {
            return true;
        }
        return false;
    }
}
