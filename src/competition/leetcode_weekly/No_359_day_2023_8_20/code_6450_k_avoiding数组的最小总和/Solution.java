package competition.leetcode_weekly.No_359_day_2023_8_20.code_6450_k_avoiding数组的最小总和;

import java.util.HashSet;
import java.util.Set;

/**
 * completion time = 2023.8.20
 */
class Solution {
    public int minimumSum(int n, int k) {
        Set<Integer> s = new HashSet<>();
        int tot = 0;
        int i = 1;
        while (s.size() < n) {
            if (!s.contains(k - i)) {
                tot += i;
                s.add(i);
            }
            i++;
        }
        return tot;
    }
}
