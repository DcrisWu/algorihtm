package competition.leetcode_weekly.No_345_day_2023_5_14.code_6430_找出转圈游戏输家;

import java.util.HashSet;
import java.util.Set;

/**
 * completion time = 2023.5.14
 */
class Solution {
    public int[] circularGameLosers(int n, int k) {
        Set<Integer> get = new HashSet<>();
        int begin = 0;
        get.add(begin);
        int round = 1;
        while (true) {
            begin = (begin + round * k) % n;
            if (get.contains(begin)) {
                break;
            }
            get.add(begin);
            round++;
        }
        int[] ans = new int[n - get.size()];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            if (!get.contains(i)) {
                ans[idx++] = i + 1;
            }
        }
        return ans;
    }
}
