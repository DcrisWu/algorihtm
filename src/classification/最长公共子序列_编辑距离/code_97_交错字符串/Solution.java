package classification.最长公共子序列_编辑距离.code_97_交错字符串;

/**
 * completion time = 2023.7.20
 */
class Solution {
    public boolean isInterleave(String s, String t, String target) {
        int sLen = s.length();
        int tLen = t.length();
        int targetLen = target.length();
        if (sLen + tLen != targetLen) {
            return false;
        }
        boolean[][] dp = new boolean[sLen + 1][tLen + 1];
        dp[0][0] = true;
        for (int i = 0; i <= sLen; i++) {
            for (int j = 0; j <= tLen; j++) {
                if (i > 0) {
                    dp[i][j] |= dp[i-1][j] && s.charAt(i-1) == target.charAt(i+j-1);
                }
                if (j > 0){
                    dp[i][j] |= dp[i][j-1] && t.charAt(j-1) == target.charAt(i+j-1);
                }
            }
        }
        return dp[sLen][tLen];
    }
}
