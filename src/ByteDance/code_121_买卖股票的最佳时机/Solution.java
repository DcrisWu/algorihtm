package ByteDance.code_121_买卖股票的最佳时机;

import java.awt.font.FontRenderContext;

class Solution {
    public int maxProfit(int[] prices) {
        /*// 贪心的角度，只要股票上涨就一直买
        int buy = prices[0];
        int ans = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > buy) {
                ans = Math.max(ans, prices[i] - buy);
            }
            buy = Math.min(buy,prices[i]);
        }
        return ans;*/

        // dp角度
        int n = prices.length;
        // 初始化第一天的买卖关系
        int buy = -prices[0];
        int sell = 0;
        for (int i = 1; i < n; i++) {
            int tempBuy = buy;
            int tempSell = sell;
            buy = Math.max(tempBuy, tempSell - prices[i]);
            sell = Math.max(sell, tempBuy + prices[i]);
        }
        // 最后肯定是没有持有股票的时候，利润才会最大
        return sell;
    }
}
