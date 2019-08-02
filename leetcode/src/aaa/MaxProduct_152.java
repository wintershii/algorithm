package aaa;

/**
 * 给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
 *
 * 示例 1:
 *
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 示例 2:
 *
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-product-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxProduct_152 {


    public static void main(String[] args) {
        System.out.println(new MaxProduct_152().maxProduct(new int[]{2,3,-2,4}));
    }

    /**
     * 动态规划, 记录每一步找到的max和min, 当遇到负数时, 交换当前max和min的值
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int curMax = 1, curMin = 1;
        for (int num : nums) {
            if (num < 0) {
                int tmp = curMax;
                curMax = curMin;
                curMin = tmp;
            }
            curMax = Math.max(curMax * num, num);
            curMin = Math.min(curMin * num, num);

            max = Math.max(max,curMax);
        }
        return max;
    }
}
