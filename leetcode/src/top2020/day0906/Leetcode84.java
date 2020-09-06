package top2020.day0906;

import java.util.Stack;

/**
 * 柱状图中最大的矩形
 * 单调栈
 */
public class Leetcode84 {
    public int largestRectangleArea(int[] heights) {
        int[] tmp = new int[heights.length+2];
        System.arraycopy(heights, 0 , tmp, 1, heights.length);
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        //维护一个单调递减栈
        //当当前元素小于栈顶元素时，弹栈
        for (int i = 0; i < tmp.length; ++i) {
            //栈非空
            while (!stack.isEmpty() && tmp[i] < tmp[stack.peek()]) {
                int h = tmp[stack.pop()];
                res = Math.max(res, (i-stack.peek()-1) * h);
            }
            stack.push(i);
        }
        return res;
    }
}
