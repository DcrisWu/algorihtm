package TowardsOffer2.day_31_动态规划.code_091_粉刷房子;

/**
 * completion time = 2011.11.9
 */
class Solution {
    public int minCost(int[][] costs) {
        // 0-red, 1-blue, 2-green
        // dp存的是每间房子选择对应颜色时，已知的最小成本
        int[][] dp = new int[costs.length][3];
        System.arraycopy(costs[0], 0, dp[0], 0, 3);
        for (int i = 1; i < costs.length; i++) {
            for (int j = 0; j < 3; j++) {
                dp[i][j] = Math.min(dp[i - 1][(j + 1) % 3], dp[i - 1][(j + 2) % 3]) + costs[i][j];
            }
        }
        int ans = Math.min(dp[costs.length - 1][0], dp[costs.length - 1][1]);
        return Math.min(ans, dp[costs.length - 1][2]);
    }
}
