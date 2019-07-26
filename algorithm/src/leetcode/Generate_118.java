package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 *
 *
 *
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 *
 * 输入: 5
 * 输出:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pascals-triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Generate_118 {
    public List<List<Integer>> generate(int numRows) {
        if (numRows == 0) {
            return new ArrayList<>();
        }
        int[][] array = new int[numRows][numRows];
        array[0][0] = 1;
        for (int i = 1; i < numRows; i++) {
            for (int j = 0; j < numRows; j++) {
                if (j == 0 || i == j) {
                    array[i][j] = 1;
                } else {
                    array[i][j] = array[i-1][j-1] + array[i-1][j];
                }

            }
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0 ; j < numRows; j++) {
                if (array[i][j] != 0) {
                    list.add(array[i][j]);
                }
            }
            res.add(list);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Generate_118().generate(5));
    }
}
