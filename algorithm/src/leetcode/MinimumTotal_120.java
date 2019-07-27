package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 *
 * 例如，给定三角形：
 *
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 *
 * 说明：
 *
 * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinimumTotal_120 {

    int min = Integer.MAX_VALUE;


    public int minimumTotal(List<List<Integer>> triangle) {
//        search(0,triangle,0,0);
//        return min;
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        int dp[] = new int[triangle.size()+!];
        for (int i = triangle.size() - 1; i >= 0; i--) {
            List<Integer> list = triangle.get(i);
            for (int j = 0; j < list.size(); j++) {
                dp[j] = Math.min(dp[j],dp[j+1]) + list.get(j);

            }
        }
        return dp[0];
    }


    /**
     * 自己写的递归解法,
     42 / 43 个通过测试用例
     最后一个超时了
     * @param now
     * @param triangle
     * @param i
     * @param j
     */
    private void search(int now, List<List<Integer>> triangle, int i, int j) {
        if (i >= triangle.size()) {
            return;
        }
        int newNow = now + triangle.get(i).get(j);
        if (i == triangle.size()-1 && newNow < min) {
            min = newNow;
            return;
        }
        if (i < triangle.size() && j < triangle.get(i).size()) {
            search(newNow,triangle,i+1,j);
            search(newNow,triangle,i+1,j+1);
        }
    }
}
