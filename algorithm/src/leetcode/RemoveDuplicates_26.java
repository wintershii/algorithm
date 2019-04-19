package leetcode;

public class RemoveDuplicates_26 {
    public static void main(String[] args) {
        int[] arr = new int[]{0,0,1,1,1,2,2,3,3,4};
        int n = new RemoveDuplicates_26().removeDuplicates(arr);
        for (int i = 0; i  < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    /**
     * 随便写的...一次过
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int pointer = 0;
        for (int i = 0; i < nums.length; ++i) {
            while (i + 1 < nums.length && nums[i] == nums[i+1]) {
                ++i;
            }
            if (i + 1 < nums.length) {
                ++pointer;
                nums[pointer] = nums[i+1];
            }
        }
        return pointer + 1;
    }
}
