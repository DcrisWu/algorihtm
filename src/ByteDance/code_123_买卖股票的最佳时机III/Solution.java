package ByteDance.code_123_买卖股票的最佳时机III;

class Solution {
    /**
     * 每天有5种选择：
     * 1.不执行任何操作
     * 2.执行第一次买操作
     * 3.卖了第一支股票，完成一笔操作
     * 4.买了第二支股票
     * 5.卖了第二支股票
     */
    public int maxProfit(int[] prices) {
        // 不执行任何操作，可以不用记录
        // 执行完任意操作后的受益
        int buy1 = -prices[0], sell1 = 0, buy2 = -prices[0], sell2 = 0;
        for (int i = 1; i < prices.length; i++) {
            buy1 = Math.max(buy1, -prices[i]);
            sell1 = Math.max(sell1, prices[i] + buy1);
            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }
        return sell2;
    }
}