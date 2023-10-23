package ByteDance.code_122_买卖股票的最佳时机II;

class Solution {
    public int maxProfit(int[] prices) {
        int buy = -prices[0];
        int sell = 0;
        for (int i = 1; i < prices.length; i++) {
            buy = Math.max(buy, sell - prices[i]);
            sell = Math.max(sell, buy + prices[i]);
        }
        return sell;
    }
}
