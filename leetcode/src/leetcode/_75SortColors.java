package leetcode;

/**
 * 颜色分类
 */
public class _75SortColors {

    public static void main(String[] args) {
        int[] nums = new int[]{2,0,2,1,1,0};
        for (int t : nums) {
            System.out.print(t + " ");
        }
        System.out.println();
        new _75SortColors().sortColors(nums);
        for (int t : nums) {
            System.out.print(t + " ");
        }

    }


    /**
     * 三路排序
     * @param nums
     */
    public void sortColors(int[] nums) {
        int red = 0, white = 0, blue = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[blue++] = 2;
                nums[white++] = 1;
                nums[red++] = 0;
            } else if (nums[i] == 1) {
                nums[blue++] = 2;
                nums[white++] = 1;
            } else if (nums[i] == 2) {
                nums[blue++] = 2;
            }
        }
    }

}
