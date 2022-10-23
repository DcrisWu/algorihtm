package algorithm.day_18.code_322;

import java.util.Arrays;

/**
 * completion time = 2022.9.27
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1, 2, 5};
        System.out.println(solution.coinChange(arr, 11));
    }

    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] < 0) {
                    break;
                }
                if (dp[i - coins[j]] != -1) {
                    if(dp[i] == -1){
                        dp[i] = dp[i - coins[j]] + 1;
                    }else {
                        dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                    }
                }
            }
        }
        return dp[amount];
    }
}
