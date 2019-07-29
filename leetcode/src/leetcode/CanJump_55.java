package leetcode;

public class CanJump_55 {
    private boolean canJump = false;

    public static void main(String[] args) {
        int[] arr = new int[]{8,2,4,4,4,9,5,2,5,8,8,0,8,6,9,1,1,6,3,5,1,2,6,6,0,4,8,6,0,3,2,8,7,6,5,1,7,0,3,4,8,3,5,9,0,4,0,1,0,5,9,2,0,7,0,2,1,0,8,2,5,1,2,3,9,7,4,7,0,0,1,8,5,6,7,5,1,9,9,3,5,0,7,5};
        System.out.println(new CanJump_55().canJump(arr));
    }



    public boolean canJump(int[] nums) {
        int n = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] >= n) {
                n = 1;
            } else {
                n++;
            }
            if (i == 0 && n > 1) {
                return false;
            }
        }
        return true;
    }



    public boolean canJump2(int[] nums) {
        jump(0, nums);
        return canJump;
    }



    /**
     * 递归解法超时
     * @param now
     * @param nums
     */
    public void jump(int now, int[] nums) {
        if (now > nums.length) {
            return;
        }
        if (now == nums.length) {
            canJump = true;
            return;
        }
        for (int i = 1; i <= nums[now]; i++) {
            if (now + i <= nums.length) {
                jump(now+i,nums);
            }
        }
    }
}
