package leetcode;

public class ThreeNumClosest {
    public static void main(String[] args) {

    }

    public int threeSumClosest(int[] nums, int target) {
        int ans;
    }

    private void search(int[] nums, int target, int k, int ans) {
        if (k >= 3) {
            return;
        }
        Math.abs(target-ans),Math.abs(target-search(nums,target,k+1,ans));
    }
}
