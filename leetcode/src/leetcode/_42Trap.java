package leetcode;

/**
 * leetcode 接雨水
 */
public class _42Trap {

    /**
     * 使用双指针法
     * @param height
     * @return
     */
    public int trap(int[] height) {
        if (height == null || height.length <= 2) {
            return 0;
        }
        int i = 0;
        int j = height.length - 1;
        int ans = 0;
        int secHeight = 0;
        while (i < j) {
            if (height[i] < height[j]) {
                secHeight = Math.max(secHeight,height[i]);
                ans += secHeight - height[i];
                i++;
            } else {
                secHeight = Math.max(secHeight,height[j]);
                ans += secHeight - height[j];
                j--;
            }
        }
        return ans;
    }
}
