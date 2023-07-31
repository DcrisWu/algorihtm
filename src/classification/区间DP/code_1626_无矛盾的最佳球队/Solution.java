package classification.区间DP.code_1626_无矛盾的最佳球队;

import java.util.Arrays;

/**
 * completion time = 2023.7.22
 *
 * 不会二分+贪心时候，就使用dp，因为本质上还是最长递增子序列
 */
public class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length;
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = ages[i];
            arr[i][1] = scores[i];
        }
        Arrays.sort(arr, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });
        // dp[i]表示以arr[i]结尾的最多得分
        int[] dp = new int[n];
        dp[0] = arr[0][1];
        int ans = dp[0];
        for (int i = 1; i < n; i++) {
            dp[i] = arr[i][1];
            for (int j = 0; j < i; j++) {
                // 如果年龄相等 || 年龄更大且得分>=年龄小的
                if ((arr[i][0] == arr[j][0]) || (arr[i][0] > arr[j][0] && arr[i][1] >= arr[j][1])) {
                    dp[i] = Math.max(dp[i], dp[j] + arr[i][1]);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] scores = {2, 8, 9};
        int[] age = {5, 2, 5};
        System.out.println(new Solution().bestTeamScore(scores, age));
    }
}
