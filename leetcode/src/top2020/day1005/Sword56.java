package top2020.day1005;

public class Sword56 {

    public static void main(String[] args) {
        System.out.println(new Sword56().singleNumber(new int[]{3,4,3,3}));
    }

    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < 32; ++i) {
            int cover = (1 << i);
            int count = 0;
            for (int num : nums) {
                if ((num & cover) == cover) {
                    count++;
                }
            }
            System.out.println(cover + " " + count);
            if (count % 3 != 0) {
                res |= cover;
            }
        }
        return res;
    }
}
