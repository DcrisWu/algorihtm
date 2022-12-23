package TowardsOffer2_Special.day_35_动态规划.code_103_最少的硬币数目;

import java.util.Arrays;

/**
 * completion time = 2022.11.14
 */
class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0){
            return 0;
        }
        Arrays.sort(coins);
        int[] dp = new int[amount + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < coins.length && i - coins[j] >= 0; j++) {
                if (i - coins[j] == 0) {
                    dp[i] = 1;
                } else {
                    if (i - coins[j] != 0 && dp[i - coins[j]] != 0) {
                        if (dp[i] == 0) {
                            dp[i] = dp[i - coins[j]] + 1;
                        }else {
                            dp[i] = Math.min(dp[i],dp[i - coins[j]] + 1);
                        }
                    }
                }
            }
        }
        return dp[amount] == 0 ? -1 : dp[amount];
    }

}
