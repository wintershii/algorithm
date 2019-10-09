package leetcode;

/**
 * 删除排序数组中的重复项2
 */
public class _20RemoveDuplicates2 {

    public static void main(String[] args) {
        int[] nums = new int[]{0,0,1,1,1,1,2,3,3};
        int len = new _20RemoveDuplicates2().removeDuplicates(nums);
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i] + " ");
        }
    }


    /**
     * 大神的写法...
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int len = 0;
        //设置一个标志,出现重复时为true
        boolean flag = false;
        //从下标为1的位置开始
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

    /**
     * 自己写出来的, 遍历一遍
     * @param nums
     * @return
     */
    public int removeDuplicates2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int j = 0;
        for (int i = 0; i < nums.length; ) {
            if(i == nums.length - 1) {
                nums[j++] = nums[i];
                break;
            }
            if (nums[i] != nums[i + 1]) {
                nums[j++] = nums[i++];
                continue;
            }
            nums[j++] = nums[i++];
            nums[j++] = nums[i];
            while (i + 1 != nums.length && nums[i] == nums[i+1])
                i++;
            i++;
        }
        return j;
    }
}
