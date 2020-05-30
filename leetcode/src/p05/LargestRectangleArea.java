package p05;

import java.util.ArrayDeque;
import java.util.Deque;

public class LargestRectangleArea {
    public static void main(String[] args) {
        System.out.println(new LargestRectangleArea().largestRectangleArea_1(new int[]{1,1}));
    }

    /**
     * 单调栈
     * 对栈中柱体来说，栈中的下一个柱体就是其「左边第一个小于自身的柱体」；
     * 若当前柱体 i 的高度小于栈顶柱体的高度，说明 i 是栈顶柱体的「右边第一个小于栈顶柱体的柱体」。
     * 因此以栈顶柱体为高的矩形的左右宽度边界就确定了，可以计算面积
     * @param heights
     * @return
     */
    public int largestRectangleArea_1(int[] heights) {
        int[] tmp = new int[heights.length + 2];
        System.arraycopy(heights,0,tmp,1,heights.length);
        Deque<Integer> stack = new ArrayDeque<>();
        int res = 0;
        for (int i = 0; i < tmp.length; ++i) {
            while (!stack.isEmpty() && tmp[i] < tmp[stack.peek()]) {
                int h = tmp[stack.pop()];
                res = Math.max(res, (i - stack.peek() - 1) * h);
            }
            stack.push(i);
        }
        return res;
    }



    /**
     * 暴力解法
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0) {
            return 0;
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < heights.length; ++i) {
            int h = heights[i];
            int w = 1;
            for (int j = i - 1; j >= 0 && heights[j] >= heights[i]; --j) {
                w++;
            }
            for (int j = i + 1; j < heights.length && heights[j] >= heights[i]; ++j) {
                w++;
            }
            res = Math.max(res,w * h);
        }
        return res;
    }


}
