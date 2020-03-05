package microsoft;

/**
 * 给定长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 *
 * 示例:
 *
 * 输入: [1,2,3,4]
 * 输出: [24,12,8,6]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/product-of-array-except-self
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _238ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return new int[]{0};
        }
        int[] res = new int[len];
        //从左向右遍历
        int num = 1;
        for (int i = 0; i < len; ++i) {
            res[i] = num;
            num *= nums[i];
        }
        //从右向左遍历
        num = 1;
        for (int i = len - 1; i >= 0; --i) {
            res[i] *= num;
            num *= nums[i];
        }
        return res;
    }
}
