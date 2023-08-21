package classification.会议室_会议加权.code_2008_出租车的最大盈利;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * completion time = 2023.8.21
 */
class Solution {
    public long maxTaxiEarnings(int n, int[][] rides) {
        Arrays.sort(rides, Comparator.comparingInt(a -> a[1]));
        long[] dp = new long[n + 1];
        List<int[]>[] group = new ArrayList[n + 1];
        Arrays.setAll(group, e -> new ArrayList<>());
        for (int[] ride : rides) {
            // 以ridi[1]结尾的节点的{start,tip}集合
            group[ride[1]].add(new int[]{ride[0], ride[2]});
        }
        // 到达i点，至少跟到达i-1点一样的钱
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1];
            for (int[] g : group[i]) {
                dp[i] = Math.max(dp[i], dp[g[0]] + (i - g[0] + g[1]));
            }
        }
        return dp[n];
    }
}
