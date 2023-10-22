package classification.动态规划.完全背包.code_279_完全平方数;

import java.util.Arrays;

class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n + 1);
        // 一定要初始化
        dp[0] = 0;
        // dp[i][j] = min(dp[i-1[j],dp[i][j-i*i]+1)
        for (int i = 1; i * i <= n; i++) {
            for (int j = i * i; j <= n; j++) {
                dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        new Solution().numSquares(12);
    }
}
