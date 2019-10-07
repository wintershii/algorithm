package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 复原ip地址
 */
public class _93RestoreIpAdress {

    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        search(s,"",0,res);
        return res;
    }

    /**
     * 搜索, 传入剩余字符, 当前字符, 第几次, 和结果集
     * @param s
     * @param now
     * @param n
     * @param res
     */
    private void search(String s, String now, int n,List<String> res) {
        //递归出口
        if (n == 4) {
            //如果已经用完了s.再添加结果
            if (s.isEmpty()) {
                res.add(now);
            }
            return;
        }
        //长度1,2,3一次实验
        for (int i = 1; i < 4; ++i) {
            //如果茶度不够就停
            if (s.length() < i) {
                break;
            }
            //获取截取后的值
            int val = Integer.parseInt(s.substring(0,i));
            //不符合要求,大于255或者格式不对(例如01)这种,直接下一个
            if (val > 255 || i != String.valueOf(val).length()) {
                continue;
            }
            //进行搜索, 将前面的s截取了 并放到 now字符串后边, 加上 . ,进行递归
            search(s.substring(i),s.substring(0,i) + (n == 3 ? "" : "."),n+1,res);
        }


    }
}
