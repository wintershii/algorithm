package leetcode;

public class GetWater_11 {
    public static void main(String[] args) {
        System.out.println(new GetWater_11().maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }

    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1;
        int ans = 0;
        while (i < j) {
            int water = (j-i) * Math.min(height[i],height[j]);
            ans = Math.max(ans,water);
            if (height[i] > height[j]) {
                j--;
            } else {
                i++;
            }
        }
        return ans;
    }
}
