package basicAlgorithm.day_18.code_343;

/**
 * completion time = 2022.9.27
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.integerBreak(8));
    }

    public int integerBreak(int n) {
        int[] dp = new int[n-1];
        dp[0] = 1;
        for (int i = 1; i <= n - 2; i++) {
            for (int j = i - 1; j >= 0; j--) {
                dp[i] = Math.max(dp[i], (i - j) * Math.max(j + 2, dp[j]));
            }
        }
        return dp[n - 2];
    }
}
