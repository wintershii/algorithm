package ali;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Poker {

    public static void main(String[] args) {

        //10种牌，输入每种牌的张数
        Scanner sc = new Scanner(System.in);
        //测试
//        int[] arr = new int[]{1,2,2,2,1,1,1,2,1,2};
//        int[] arr = new int[]{1,1,1,2,2,2,2,2,1,1};
        int[] arr = new int[10];
        for(int i = 0; i < 10; i++)
            arr[i] = sc.nextInt();

        //打印最快出牌情况
        List<List<Integer>> res = dfs(arr,0);
        for(List<Integer> lst : res)
            System.out.println(lst);

        //打印最快出牌次数
        System.out.println(res.size());

    }

    public static List<List<Integer>> dfs(int[] arr, int index){
        if(index >= arr.length)
            return new ArrayList<>();
        if(arr[index]==0) return dfs(arr,index+1);

        //打双牌
        List<List<Integer>> res = getMincount(arr,index,1,2);  //从index开始num种牌，每种牌至少有count张

        //打单牌
        List<List<Integer>> res1 = getMincount(arr,index,1,1);
        if(res.isEmpty() || (res1.size() != 0 && res.size() > res1.size()))
            res = new ArrayList<>(res1);

        //打顺子
        res1 = getMincount(arr,index,5,1);
        if(res.isEmpty() || (res1.size() != 0 && res.size() > res1.size()))
            res=new ArrayList<>(res1);

        //打连对
        res1 = getMincount(arr,index,3,2);
        if(res.isEmpty() || (res1.size() !=0 && res.size() > res1.size()))
            res=new ArrayList<>(res1);

        return res;
    }

    /**
     * @param arr  牌数
     * @param index 从index开始
     * @param num   打连续num种牌
     * @param count  每张牌打count张
     * @return
     */
    private static List<List<Integer>> getMincount(int[] arr, int index,int num, int count){

        List<List<Integer>> reslist = new ArrayList<>();

        //判断一下是否可以出牌
        if(arr.length - index < num) return new ArrayList<>();
        List<Integer> lst = new ArrayList<>();
        for(int k = index; k < index + num; k++) {
            lst.add(k);
            if (arr[k] < count)
                return new ArrayList<>();
        }
        reslist.add(lst);

        //出牌
        operate(arr,index,num,-1*count);
        //dfs
        reslist.addAll(dfs(arr, index));
        //回溯
        operate(arr,index,num,count);
        return reslist;
    }

    private static void operate(int[] arr, int index, int num, int add){
        if(arr.length-index<num) return;
        int end = index + num;
        while (index < end){
            arr[index] += add;
            index++;
        }
    }

}
