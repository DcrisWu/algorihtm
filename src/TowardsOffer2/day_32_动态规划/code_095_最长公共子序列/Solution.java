package TowardsOffer2.day_32_动态规划.code_095_最长公共子序列;

/**
 * completion time = 2022.11.12
 */
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];
        for (int i = 0; i < text1.length(); i++) {
            if (i == 0) {
                dp[i][0] = text1.charAt(0) == text2.charAt(0) ? 1 : 0;
            } else {
                dp[i][0] = text1.charAt(i) == text2.charAt(0) ? 1 : dp[i - 1][0];
            }

        }
        for (int i = 0; i < text2.length(); i++) {
            if (i == 0) {
                dp[0][i] = text1.charAt(0) == text2.charAt(0) ? 1 : 0;
            } else {
                dp[0][i] = text1.charAt(0) == text2.charAt(i) ? 1 : dp[0][i - 1];
            }
        }
        for (int i = 1; i < text1.length(); i++) {
            for (int j = 1; j < text2.length(); j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
                }

            }
        }
        return dp[text1.length() - 1][text2.length() - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestCommonSubsequence("abcde", "ace"));
    }
}