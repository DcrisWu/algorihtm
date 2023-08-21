package classification.会议室_会议加权.code_2054_两个最好的不重叠活动;

import java.util.Arrays;

/**
 * completion time = 2023.8.21
 */
class Solution {
    public int maxTwoEvents(int[][] events) {
        int n = events.length;
        int[][] dp = new int[n][3];
        Arrays.sort(events, (a, b) -> a[1] - b[1]);
        dp[0][1] = events[0][2];
        dp[0][2] = events[0][2];
        for (int i = 1; i < n; i++) {
            for (int j = 2; j > 0; j--) {
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
        return dp[n - 1][2];
    }
}