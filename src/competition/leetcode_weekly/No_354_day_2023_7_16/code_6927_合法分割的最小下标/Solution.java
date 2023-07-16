package competition.leetcode_weekly.No_354_day_2023_7_16.code_6927_合法分割的最小下标;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * completion time = 2023.7.16
 */
class Solution {
    public int minimumIndex(List<Integer> nums) {
        int most = 0;
        int n = nums.size();
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
            if (count.get(num) * 2 > n) {
                most = num;
            }
        }
        int freq = count.get(most);
        int pre = 0;
        for (int i = 0; i < n; i++) {
            if (nums.get(i) == most) {
                pre++;
            }
            if ((pre * 2 > i + 1) && ((freq - pre) * 2 > n - 1 - i)){
                return i;
            }
        }
        return -1;
    }
}