package array;

import java.util.Arrays;

/**
 * 题目：数组中的第K个最大元素
 */
public class TheNumerKOfArray {
    public static void main(String[] args) {
        System.out.println(new TheNumerKOfArray().mySolve(new int[]{3,2,3,1,2,4,5,5,6},2));
    }

    /**
     * 先排序然后再找就行了...
     * 肯定有效率更高的算法，得学习一下
     */
    public int mySolve(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}
