package leetcode;

public class RemoveDuplicates2_80 {

    public static void main(String[] args) {
        int[] nums = new int[]{0,0,1,1,1,1,2,3,3};
        int len = new RemoveDuplicates2_80().removeDuplicates(nums);
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i] + " ");
        }
    }


    public int removeDuplicates(int[] nums) {
        int len = 0;
        boolean flag = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i-1]) {
                nums[++len] = nums[i];
                flag = false;
            } else {
                if (!flag) {
                    flag = true;
                    nums[++len] = nums[i];
                }
            }
        }
        return len + 1;
    }
}
