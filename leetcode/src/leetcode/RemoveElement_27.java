package leetcode;

public class RemoveElement_27 {
    public static void main(String[] args) {
        int[] arr = new int[]{3,2,2,3};
        int n = new RemoveElement_27().removeElement(arr,3);
        for (int i = 0; i  < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

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
