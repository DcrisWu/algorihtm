package daily.year_2023.January.day_11_code_2283_判断一个数的数字计数是否等于数位的值;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean digitCount(String num) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < num.length(); i++) {
            map.put(num.charAt(i) - '0', map.getOrDefault(num.charAt(i) - '0', 0) + 1);
        }
        for (int i = 0; i < num.length(); i++) {
            if (map.getOrDefault(i,0) != num.charAt(i)-'0'){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println((int)1e9);
    }
}