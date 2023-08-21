package classification.会议室_会议加权.code_1751_最多可以参加的会议数目II;

import java.util.Arrays;
import java.util.Comparator;

/**
 * completion time = 2023.8.21
 */
class Solution {
    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, Comparator.comparingInt(a -> a[1]));
        int n = events.length;
        // dp[i][k]表示在第i的会议期间，最多参加k次会议的价值
        int[][] dp = new int[n][k + 1];
        for (int i = 1; i <= k; i++) {
            dp[0][i] = events[0][2];
        }
        for (int i = 1; i < n; i++) {
            // 从后往前遍历，避免更新后的值影响后来的值,有点像0-1背包
            for (int j = k; j > 0; j--) {
                dp[i][j] = Math.max(dp[i - 1][j], events[i][2]);
                int l = 0, r = i - 1;
                int t = -1;
                while (l <= r) {
                    int mid = (l + r) >> 1;
                    if (events[mid][1] < events[i][0]) {
                        t = mid;
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
                if (t != -1) {
                    dp[i][j] = Math.max(dp[i][j], dp[t][j - 1] + events[i][2]);
                }
            }
        }
        return dp[n - 1][k];
    }
}