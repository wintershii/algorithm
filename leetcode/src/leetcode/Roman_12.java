package leetcode;

import java.util.HashMap;

public class Roman_12 {
    public static void main(String[] args) {
        System.out.println(new Roman_12().intToRoman(1994));
        System.out.println(new Roman_12().romanToInt("MCMXCIV"));
    }

    public String intToRoman(int num) {
        int[] arr = new int[] {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] strs = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < arr.length && num != 0; ) {
            if (num - arr[i] >= 0) {
                num -= arr[i];
                builder.append(strs[i]);
            } else {
                i++;
            }
        }
        return builder.toString();
    }


    public int romanToInt(String s) {
        HashMap<String,Integer> map = new HashMap<>();
        int ans = 0;
        map.put("M",1000);
        map.put("CM",900);
        map.put("D",500);
        map.put("CD",400);
        map.put("C",100);
        map.put("XC",90);
        map.put("L",50);
        map.put("XL",40);
        map.put("X",10);
        map.put("IX",9);
        map.put("V",5);
        map.put("IV",4);
        map.put("I",1);

        for (int i = 0; i < s.length(); ) {
            String tmp;
            if (i == s.length() - 1) {
                tmp = String.valueOf(s.charAt(i));
                ans += map.get(tmp);
                break;
            }

            tmp = s.substring(i,i+2);
            if (map.containsKey(tmp)) {
                ans += map.get(tmp);
                i += 2;
            } else {
                tmp = String.valueOf(s.charAt(i));
                ans += map.get(tmp);
                i++;
            }
        }
        return ans;
    }
}
