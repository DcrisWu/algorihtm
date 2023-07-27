package classification.买卖股票的最佳时机.code_714_买卖股票的最佳时机含手续费;

class Solution {
    public int maxProfit(int[] prices, int fee) {
        // 第1天的最优解肯定不是不买卖股票，因为买卖后肯定要亏fee
        int f0 = 0;
        int f1 = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            int temp = Math.max(f0, f1 + prices[i] - fee);
            f1 = Math.max(f1, f0 - prices[i]);
            f0 = temp;
        }
        return f0;
    }
}