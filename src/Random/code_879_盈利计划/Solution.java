package Random.code_879_盈利计划;

/**
 * completion time = 2023.4.9
 */
class Solution {
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int length = group.length;
        int[][] dp = new int[n + 1][minProfit + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        int mod = (int) (1e9 + 7);
        for (int i = 0; i < length; i++) {
            int human = group[i];
            int pro = profit[i];
            for (int j = n; j >= human; j--) {
                for (int k = minProfit; k >= 0; k--) {
                    dp[j][k] = (dp[j][k] + dp[j - human][Math.max(0, k - pro)]) % mod;
                }
            }
        }
        return dp[n][minProfit];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] group = {2, 2};
        int[] profit = {2, 3};
        System.out.println(solution.profitableSchemes(5, 3, group, profit));
    }
}