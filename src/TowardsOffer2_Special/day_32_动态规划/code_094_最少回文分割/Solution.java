package TowardsOffer2_Special.day_32_动态规划.code_094_最少回文分割;

import java.util.Arrays;

/**
 * completion time = 2022.11.12
 */
class Solution {

    public int minCut(String s) {
        boolean[][] state;
        state = new boolean[s.length()][s.length()];
        for (boolean[] booleans : state) {
            Arrays.fill(booleans, true);
        }
        for (int i = s.length() - 2; i >= 0; i--) {
            for (int j = i + 1; j < s.length(); j++) {
                state[i][j] = s.charAt(i) == s.charAt(j) && state[i + 1][j - 1];
            }
        }
        int[] dp = new int[s.length()];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i = 0; i < dp.length; i++) {
            // 如果 0-i 已经是回文子串，就不用分割
            if (state[0][i]) {
                dp[i] = 0;
            } else {
                // 否则就用动态规划
                for (int j = 0; j < i; j++) {
                    if (state[j + 1][i]) {
                        dp[i] = Math.min(dp[i], dp[j] + 1);
                    }
                }
            }
        }
        return dp[s.length() - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minCut("ab"));
    }
}
