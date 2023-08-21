package classification.会议室_会议加权.code_1235_规划兼职工作;

import java.util.Arrays;
import java.util.Comparator;

/**
 * completion time = 2023.8.21
 */
class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            arr[i][0] = startTime[i];
            arr[i][1] = endTime[i];
            arr[i][2] = profit[i];

        }
        Arrays.sort(arr, Comparator.comparingInt(a -> a[1]));
        int[] dp = new int[n];
        dp[0] = arr[0][2];
        for (int i = 1; i < n; i++) {
            // 假设只做这一份工作 || 不做当前的工作
            dp[i] = Math.max(arr[i][2], dp[i - 1]);
            int l = 0, r = i - 1;
            int t = -1;
            while (l <= r) {
                int mid = (l + r) >> 1;
                if (arr[mid][1] <= arr[i][0]) {
                    t = mid;
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            if (t != -1) {
                dp[i] = Math.max(dp[i], dp[t] + arr[i][2]);
            }
        }
        return dp[n - 1];
    }
}
