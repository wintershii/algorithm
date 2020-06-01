package p05;

import java.util.ArrayList;
import java.util.List;

/**
 * 六一彩蛋
 */
public class KidsWithCandies_1431 {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        for (int i = 0;i < candies.length; ++i) {
            if (candies[i] > max) {
                max = candies[i];
            }
        }
        List<Boolean> res = new ArrayList<>();
        for (int i = 0; i < candies.length; ++i) {
            if (candies[i] + extraCandies >= max) {
                res.add(true);
            } else {
                res.add(false);
            }
        }
        return res;
    }
}
