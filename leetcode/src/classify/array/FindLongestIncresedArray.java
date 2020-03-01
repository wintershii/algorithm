package classify.array;

/**
 * 题目：最长连续递增序列
 * 来源:leetcode字节跳动专栏
 */
public class FindLongestIncresedArray {
    public static void main(String[] args) {
        System.out.println(new FindLongestIncresedArray().myFindLengthOfLCIS(new int[]{1}));
    }

    /**
     * 自己写的，遍历一遍数组记录下最大连续递增数目，返回
     * 感觉还有更好的解法
     * @param nums
     * @return
     */
    public int myFindLengthOfLCIS(int[] nums) {
        int ans = 1;
        int max = 0;
        if (nums.length == 1) {
            return 1;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i+1] > nums[i]) {
                ans++;
            } else {
                ans = 1;
            }
            if (ans > max) {
                max = ans;
            }
        }
        return max;
    }
}
