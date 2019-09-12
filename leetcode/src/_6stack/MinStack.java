package _6stack;

import java.util.Stack;

public class MinStack {

    private int[] arr;
    private int top;
    private Stack<Integer> stack;

    public MinStack() {
        arr = new int[1000];
        top = 0;
        stack = new Stack();
    }

    public void push(int x) {
        arr[top++] = x;
        if (stack.empty()) {
            stack.push(x);
        } else {
            if (x < stack.peek()) {
                stack.push(x);
            } else {
                stack.push(stack.peek());
            }
        }
    }

    public void pop() {
        int v = arr[--top];
        stack.pop();
        return;
    }

    public int top() {
        return arr[top-1];
    }

    public int getMin() {
        return stack.peek();
    }
}
