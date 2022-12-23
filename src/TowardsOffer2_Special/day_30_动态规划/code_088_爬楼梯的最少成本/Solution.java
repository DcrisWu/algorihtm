package TowardsOffer2_Special.day_30_动态规划.code_088_爬楼梯的最少成本;

/**
 * completion time = 2022.11.9
 */
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        /*int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        }
        return Math.min(dp[dp.length - 1], dp[dp.length - 2]);*/
        int pre1 = cost[0];
        int pre2 = cost[1];
        for (int i = 2; i < cost.length; i++) {
            int now = Math.min(pre1, pre2) + cost[i];
            pre1 = pre2;
            pre2 = now;
        }
        return Math.min(pre1, pre2);
    }
}
