package daily.year_2023.January.day_17_code_1814_统计一个数组中好对子的数目;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int countNicePairs(int[] nums) {
        int[] rev = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            rev[i] = getReverse(nums[i]);
        }
        Map<Integer, Integer> count = new HashMap<>();
        int ans = 0;
        int mod = (int) 1e9 + 7;
        for (int i = 0; i < nums.length; i++) {
            ans = (count.getOrDefault(nums[i] - rev[i], 0) + ans) % mod;
            count.put(nums[i] - rev[i], count.getOrDefault(nums[i] - rev[i], 0) + 1);
        }
        return ans;
    }

    int getReverse(int num) {
        if (num == 0){
            return num;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(num));
        sb.reverse();
        int i = 0;
        while (i < sb.length() && sb.charAt(i) == '0') {
            i++;
        }
        return Integer.parseInt(sb.substring(i));
    }
}
