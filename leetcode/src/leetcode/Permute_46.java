package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Permute_46 {
    public static void main(String[] args) {
        System.out.println(new Permute_46().permute(new int[]{1,1,2}));
    }

    public List<List<Integer>> permute(int[] nums) {
        boolean[] book = new boolean[nums.length];
        List<List<Integer>> list = new ArrayList<>();
        search2(nums,0,book,list,new ArrayList<>());
        return list;
    }

    public static void search(int[] nums, int k, boolean[] book, List<List<Integer>> list, List<Integer> now) {
        if (k >= nums.length) {
            list.add(new ArrayList<>(now));
        }
        for (int i = 0; i < nums.length; i++) {
            if (book[i]) continue;
            now.add(nums[i]);
            book[i] = true;
            search(nums,k+1,book,list,now);
            book[i] = false;
            now.remove(now.size()-1);
        }
    }

    public static void search2(int[] nums, int k, boolean[] book, List<List<Integer>> list, List<Integer> now) {
        if (k >= nums.length) {
            for (List<Integer> check : list) {
                if (check(now,check))
                    return;
            }
            list.add(new ArrayList<>(now));
        }
        for (int i = 0; i < nums.length; i++) {
            if (book[i]) continue;
            now.add(nums[i]);
            book[i] = true;
            search2(nums,k+1,book,list,now);
            book[i] = false;
            now.remove(now.size()-1);
        }
    }

    public static boolean check(List<Integer> l1, List<Integer> l2) {
        if (l1.size() != l2.size()) {
            return false;
        }
        for (int i = 0; i < l1.size(); i++) {
            if (l1.get(i).intValue() != l2.get(i).intValue()) {
                return false;
            }
        }
        return true;
    }
}
