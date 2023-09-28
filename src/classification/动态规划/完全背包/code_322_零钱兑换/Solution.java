package classification.动态规划.完全背包.code_322_零钱兑换;

import java.util.Arrays;

/**
 * completion time = 2023.7.20
 *
 * 背包问题，就是把价值的所有可能情况全部列出来，用数组表示
 * 因为找零钱问题，不限制零钱使用的次数，所以是完全背包问题
 * dp[i][j]表示前i个硬币中选取若干个硬币，使得其和为j的最小硬币数
 * dp[i][j] = min(dp[i-1][j],dp[i][j-num[i]]+1)
 * 因为dp[i][j]只与dp[i-1][j]和dp[i][j-num[i]]有关，所以可以使用一维数组
 * 因为dp[i][j]直接继承dp[i-1][j]，也就是说dp[i][j]只与dp[i][j-nums[i]]有关，所以dp[i][j-nums[i]]需要在dp[i][j]之前计算
 * 需要从前往后遍历
 */
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int coin : coins) {
            for (int i = coin;i <= amount;i++){
                dp[i] = Math.min(dp[i],dp[i-coin]+1);
            }
        }
        return dp[amount] == amount+1 ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] arr = {186, 419, 83, 408};
        Solution solution = new Solution();
        int ans = solution.coinChange(arr, 6249);
        System.out.println(ans);
    }
}
