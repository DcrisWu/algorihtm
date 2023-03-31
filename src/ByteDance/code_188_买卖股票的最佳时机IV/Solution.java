package ByteDance.code_188_买卖股票的最佳时机IV;

class Solution {
    /**
     * 每天有5种选择：
     * 1.不执行任何操作
     * 2.执行第一次买操作 index = (0,0)
     * 3.卖了第一支股票，完成一笔操作 index = (0,1)
     * 4.买了第二支股票 index = (1,0)
     * 5.卖了第二支股票 index = (1,1)
     * ......
     * 4.买了第i支股票 index = (i-1,0)
     * 5.卖了第i支股票 index = (i-1,1)
     */
    public int maxProfit(int k, int[] prices) {
        int[][] dp = new int[k][2];
        // 关键是一定要初始化第0天的买卖情况，第0天的k次买卖都要相同
        for (int i = 0; i < k; i++) {
            dp[i][0] = -prices[0];
            dp[i][1] = 0;
        }
        // 从第1天开始，
        // 每一天计算出 买 和 卖 的最优解，注意的是，第一次交易比较特殊，要额外初始化，后面的交易都一样
        for (int i = 1; i < prices.length; i++) {
            dp[0][0] = Math.max(dp[0][0], -prices[i]);
            dp[0][1] = Math.max(dp[0][1], prices[i] + dp[0][0]);
            for (int j = 1; j < k; j++) {
                dp[j][0] = Math.max(dp[j][0], dp[j - 1][1] - prices[i]);
                dp[j][1] = Math.max(dp[j][1], dp[j][0] + prices[i]);
            }
        }
        return dp[k - 1][1];
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 1};
        Solution solution = new Solution();
        System.out.println(solution.maxProfit(2, arr));
    }
}
