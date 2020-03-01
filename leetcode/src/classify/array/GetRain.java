package classify.array;

/**
 * 题目：接雨水
 * 来源:leetcode字节跳动专栏
 */
public class GetRain {
    public static void main(String[] args) {
        System.out.println(new GetRain().trap(new int[]{4,2,3}));
    }

    /**
     * 网上找到的方法：从两边开始搜索
     * (太强了我脑子根本想不到啊...)
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

    /**
     * 自己写的思路，但是有问题，用例测试只通过了一半
     * @param height
     * @return
     */
    public int myTrap(int[] height) {
        if (height == null || height.length <= 2) {
            return 0;
        }
        int ans = 0;
        int beyond = -1;

        for (int i = 0; i < height.length; i++) {
            if (height[i] != 0) {
                beyond = i;
                break;
            }
        }

        for (int i = beyond + 1; i < height.length;) {
            if (height[i] < height[beyond]) {
                int behind = -1;
                for (int j = i; j < height.length; j++) {
                    if (height[j] >= height[beyond]) {
                        behind = j;
                        break;
                    }
                }
                if (behind == -1) {
                    beyond++;
                    i++;
                    continue;
                }
                int min = Math.min(height[beyond],height[behind]);
                for (int j = i; j < behind; j++) {
                    ans += min - height[j];
                }
                beyond = behind;
                i = beyond + 1;
            } else {
                beyond++;
                i++;
            }

        }
        return ans;
    }
}
