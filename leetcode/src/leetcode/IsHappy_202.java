package leetcode;

import java.util.HashSet;

public class IsHappy_202 {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        set.add(n);
        int num = n;
        for (;num != 1;) {
            int tmp = 0;
            while (num != 0) {
                int m = num % 10;
                tmp += (m * m);
                num /= 10;
            }
            if (set.contains(tmp)) {
                return false;
            } else {
                set.add(tmp);
                num = tmp;
            }
        }
        return true;
    }
}
