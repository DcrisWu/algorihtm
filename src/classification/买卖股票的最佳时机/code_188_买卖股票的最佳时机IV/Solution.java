package classification.买卖股票的最佳时机.code_188_买卖股票的最佳时机IV;

/**
 * 最多完成k笔交易的股票买卖类问题
 *
 * completion time = 2023.7.27
 */
class Solution {
    public int maxProfit(int k, int[] prices) {
        // dp[i][0]表示第一次买卖后，不持有股票时的收益
        int[][] dp = new int[k][2];
        for (int i = 0; i < k; i++) {
            dp[i][1] = -prices[0];
            dp[i][0] = 0;
        }
        for (int i = 1; i < prices.length; i++) {
            dp[0][0] = Math.max(dp[0][0], dp[0][1] + prices[i]);
            dp[0][1] = Math.max(dp[0][1], -prices[i]);
            for (int j = 1; j < k; j++) {
                dp[j][0] = Math.max(dp[j][0], dp[j][1] + prices[i]);
                dp[j][1] = Math.max(dp[j][1], dp[j - 1][0] - prices[i]);
            }
        }
        return dp[k - 1][0];
    }
}
