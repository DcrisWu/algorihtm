package classification.最长公共子序列_编辑距离.code_1143_最长公共子序列;

/**
 * completion time = 2023.7.20
 */
class Solution {
    public int longestCommonSubsequence(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        int[][] dp = new int[sLen + 1][tLen + 1];
        for (int i = 0; i < sLen; i++) {
            for (int j = 0; j < tLen; j++) {
                if (s.charAt(i) == t.charAt(j)) {
                    dp[i+1][j+1] = dp[i][j] + 1;
                }else {
                    dp[i+1][j+1] = Math.max(dp[i][j+1],dp[i+1][j]);
                }
            }
        }
        return dp[sLen][tLen];
    }
}
