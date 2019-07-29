package array;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目：第k个排列
 * 来源:leetcode字节跳动专栏
 */
public class TheNArrangement {
    private static boolean[] visited = new boolean[100];
    private static int time;
    public static void main(String[] args) {
        System.out.println(new TheNArrangement().getPermutation(4,3));
    }

    /**
     * 自己写的暴力解法:
     * 思路，一位一位搜索可能的情况,添加进入list,返回第k个结果
     * 测试样例通过情况:124/200
     */
    public String violence(int n, int k) {
        return search(n, k, new StringBuilder(),1,new ArrayList<>()).get(k-1);
    }

    public List<String> search(int n, int k, StringBuilder str, int level, List<String> list) {
        if (level == n + 1) {
            time++;
            list.add(str.toString());
            return list;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                str.append(i+1);
                //System.out.println(str);
                visited[i] = true;
                search(n,k, str, level + 1,list);
                str.deleteCharAt(level - 1);
                visited[i] = false;
            }
        }
        return list;
    }

    /**
     *　别人的写法
     * 　思路：
     */
    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        int[] array = new int[n+1];
        int sum = 1;
        array[0] = 1;

        for (int i = 1; i < n; i++) {
            sum *= i;
            array[i] = sum;
        }

        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nums.add(i+1);
        }

        k--;
        for (int i = 1; i <= n; i++) {
            int index = k / array[n - i];
            sb.append("" + nums.get(index));
            nums.remove(index);
            k = k % array[n - i];
        }
        return sb.toString();

    }


}
