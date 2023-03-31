package ByteDance.code_122_买卖股票的最佳时机II;

class Solution {
    public int maxProfit(int[] prices) {
        int buy = prices[0];
        int ans = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > buy) {
                ans += prices[i] - buy;
                buy = prices[i];
            } else {
                buy = Math.min(prices[i], buy);
            }
        }
        return ans;
    }
}
