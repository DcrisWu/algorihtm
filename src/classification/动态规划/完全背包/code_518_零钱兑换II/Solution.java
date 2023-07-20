package classification.动态规划.完全背包.code_518_零钱兑换II;

/**
 * completion time = 2023.7.20
 */
class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        // 初始化
        dp[0] = 1;
        // 完全背包正向遍历
        for (int coin : coins) {
            // 容量遍历在内层
            for (int i = 1; i <= amount; i++) {
                if (i >= coin) {
                    dp[i] += dp[i - coin];
                }
            }
        }
        return dp[amount];
    }
}
