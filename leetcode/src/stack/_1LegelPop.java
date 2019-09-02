package stack;

import java.util.Queue;
import java.util.Stack;

/**
 * 合法的出栈顺序
 * 从1..n的顺序入栈
 * 判断一个出栈序列是否合法
 */
public class _1LegelPop {

    /**
     * 使用一个队列,配合栈判断序列是否合法
     * @param order
     * @return
     */
    public boolean checkValid(Queue<Integer> order) {
        Stack<Integer> stack = new Stack();
        int n = order.size();
        for (int i = 1; i < n; ++i) {
            stack.push(i);
            while (!stack.empty() && stack.peek().intValue() == order.element()) {
                stack.pop();
                order.poll();
            }
        }
        if (!stack.empty()) {
            return false;
        }
        return true;
    }
}
