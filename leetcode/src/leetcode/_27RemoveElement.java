package leetcode;

/**
 * 移除元素
 */
public class _27RemoveElement {
    public static void main(String[] args) {
        int[] arr = new int[]{3,2,2,3};
        int n = new _27RemoveElement().removeElement(arr,3);
        for (int i = 0; i  < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    /**
     * 遍历一遍
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        int pointer = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[pointer++] = nums[i];
            }
        }
        return pointer;
    }
}
