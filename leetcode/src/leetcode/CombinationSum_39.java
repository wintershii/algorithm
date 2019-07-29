package leetcode;

import java.util.*;

public class CombinationSum_39 {
    public static void main(String[] args) {
        System.out.println(new CombinationSum_39().combinationSum(new int[]{2,5,1,2},5));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        boolean[] book = new boolean[candidates.length];
        search(candidates,target,0,new ArrayDeque<>(),list,book);
        return list;
    }

    public static void search(int[] candidates, int target, int now, Deque<Integer> nums, List<List<Integer>> list,boolean[] book) {
        if (now > target) {
            return;
        }
        if (now == target) {
            List<Integer> tmp = new ArrayList<>(nums);
            for (List<Integer> check : list) {
                if (check(tmp,check))
                    return;
            }
            list.add(tmp);
        }
        for (int i = 0; i < candidates.length; i++) {
            if (now + candidates[i] > target || book[i]) continue;
            nums.push(candidates[i]);
            book[i] = true;
            search(candidates,target,now+candidates[i],nums,list,book);
            book[i] = false;
            nums.pop();
        }
    }

    public static boolean check(List<Integer> l1, List<Integer> l2) {
        if (l1.size() != l2.size()) {
            return false;
        }
        Collections.sort(l1);
        Collections.sort(l2);
        for (int i = 0; i < l1.size(); i++) {
            if (l1.get(i).intValue() != l2.get(i).intValue()) {
                return false;
            }
        }
        return true;
    }
}
