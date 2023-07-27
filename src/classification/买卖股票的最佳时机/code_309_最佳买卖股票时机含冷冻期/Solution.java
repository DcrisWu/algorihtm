package classification.买卖股票的最佳时机.code_309_最佳买卖股票时机含冷冻期;

import java.util.Arrays;

/**
 * completion time = 2023.7.23
 */
class Solution {
    // dp[i][0] = max(dp[i-1][0],dp[i-1][1]+prices[i])
    // dp[i][1] = max(dp[i-1][1],dp[i-2][0]-prices[i])  今天买入股票的话，必须在i-2天没有持有股票
    public int maxProfit(int[] prices) {
        // 初始化第1天，因为存在i-2，所以初始化第0天
        int n = prices.length;
        int[][] dp = new int[n + 1][2];
        // 第0天不存在买卖，所以持有股票时候是0，买是非法的，初始化为最小值
        dp[0][0] = 0;
        dp[0][1] = Integer.MIN_VALUE;
        dp[1][0] = 0;
        dp[1][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i + 1][0] = Math.max(dp[i][0], dp[i][1] + prices[i]);
            dp[i + 1][1] = Math.max(dp[i][1], dp[i - 1][0] - prices[i]);
        }
        return dp[n][0];
    }
}
