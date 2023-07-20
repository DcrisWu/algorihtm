package classification.最长公共子序列_编辑距离.code_83_两个字符串的删除操作;

/**
 * completion time = 2023.7.20
 */
class Solution {
    public int minDistance(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        int[][] dp = new int[sLen + 1][tLen + 1];
        // 初始化
        for (int i = 0; i <= sLen; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= tLen; i++) {
            dp[0][i] = i;
        }
        for (int i = 0; i < sLen; i++) {
            for (int j = 0; j < tLen; j++) {
                if (s.charAt(i) == t.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j];
                } else {
                    // 讨论删除s[i]还是t[j]
                    dp[i + 1][j + 1] = Math.min(dp[i][j + 1], dp[i + 1][j]) + 1;
                }
            }
        }
        return dp[sLen][tLen];
    }
}
