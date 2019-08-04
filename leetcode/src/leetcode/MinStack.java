package leetcode;

public class MinStack {

    private int[] array;
    private int top;

    public MinStack() {
        array = new int[10000];
        top = -1;
    }

    public void push(int x) {
        if (top == -1) {
            array[1] = x;
            top = 1;
            array[0] = 1;
        } else {
            array[++top] = x;
            if (x < array[array[0]]) {
                array[0] = top;
            }
        }
    }

    public void pop() {
        if (array[0] == top) {
            int min = 1;
            for (int i = 2; i < top; i++) {
                if (array[i] < array[min]) {
                    min = i;
                }
            }
            array[0] = min;
        }
        top--;

    }

    public int top() {
        return array[top];
    }

    public int getMin() {
        return array[array[0]];
    }
}
