package classification.买卖股票的最佳时机.code_122_买卖股票的最佳时机II;

/**
 * completion time = 2023.7.23
 */
class Solution {
    public int maxProfit(int[] prices) {
        // 直接初始化第一天
        // f0表示没有持有股票，f1表示持有股票
        int f0 = 0;
        int f1 = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            int temp = Math.max(f0, f1 + prices[i]);
            f1 = Math.max(f1, f0 - prices[i]);
            f0 = temp;
        }
        return f0;
    }
}
