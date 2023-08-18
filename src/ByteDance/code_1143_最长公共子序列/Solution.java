package ByteDance.code_1143_最长公共子序列;

/**
 * completion time = 2023.8.18
 */
class Solution {
    public int longestCommonSubsequence(String s, String t) {
        int slen = s.length();
        int tlen = t.length();
        int[][] dp = new int[slen + 1][tlen + 1];
        for (int i = 0; i < slen; i++) {
            for (int j = 0; j < tlen; j++) {
                if (s.charAt(i) == t.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        return dp[slen][tlen];
    }

}
