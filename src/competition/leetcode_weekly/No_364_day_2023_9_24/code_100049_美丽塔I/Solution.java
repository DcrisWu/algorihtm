package competition.leetcode_weekly.No_364_day_2023_9_24.code_100049_美丽塔I;

import java.util.List;

class Solution {
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        long ans = 0L;
        int n = maxHeights.size();
        for (int i = 0; i < n; i++) {
            int pre = maxHeights.get(i);
            long now = pre;
            for (int j = i - 1; j >= 0; j--) {
                int temp = Math.min(maxHeights.get(j), pre);
                now += temp;
                pre = temp;
            }
            pre = maxHeights.get(i);
            for (int j = i + 1; j < n; j++) {
                int temp = Math.min(maxHeights.get(j), pre);
                now += temp;
                pre = temp;
            }
            ans = Math.max(ans, now);
        }
        return ans;
    }
}
