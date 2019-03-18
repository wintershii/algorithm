package _2013;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 错误票据
 *
 * 某涉密单位下发了某种票据,并要在年终全部收回
 * 每张票据都有唯一的id,并且是连续的.但id的开始数码是随机的
 *
 * 因为工作人员疏忽,在录入id号时发生了一处错误,造成了某个id断号,另外一个id重号
 *
 * 找到断号的id和重号的id
 *
 * 假设不会发生在最大和最小号
 */
public class _2013_07 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> list = new ArrayList<Integer>();
        int n = scan.nextInt();
        scan.nextLine();
        for (int i = 0; i < n; i++) {
            String line = scan.nextLine();
            String[] split = line.split(" ");
            for (int j = 0; j < split.length; j++) {
                list.add(Integer.parseInt(split[j]));
            }
        }
        Collections.sort(list);
        int a = 0,b = 0;
        for (int i = 1; i < list.size(); i++) {
            //自动装箱与拆箱
            if ((list.get(i) - list.get(i - 1)) == 2) {
                a = list.get(i) - 1;
            }

            //此处有坑,不能用==
            if (list.get(i).equals(list.get(i - 1))) {
                b = list.get(i);
            }
        }
        System.out.println(a + " " + b);
    }
}
