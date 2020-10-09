package top2020.day1005;

import java.util.ArrayList;
import java.util.List;

public class Sword57 {

    public static void main(String[] args) {
        System.out.println(new Sword57().findContinuousSequence(9));
    }

    /**
     * 暴力搜索
     * @param target
     * @return
     */
    public List<List<Integer>> findContinuousSequence(int target) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 1; i < target; ++i) {
            search(target, 0, i, res, new ArrayList<>());
        }
        int[][] arr = new int[res.size()][];
        return res;
    }

    public void search(int target, int sum, int index, List<List<Integer>> res, List<Integer> list) {
        if (sum > target) {
            return;
        }
        if (target == sum) {
            //System.out.println(1111);
            res.add(new ArrayList<>(list));
            return;
        }
        list.add(index);
        //System.out.println(list);
        search(target, sum+index, index+1, res, list);
        list.remove(list.size()-1);
    }
}
