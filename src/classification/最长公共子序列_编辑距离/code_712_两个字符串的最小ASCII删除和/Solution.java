package classification.最长公共子序列_编辑距离.code_712_两个字符串的最小ASCII删除和;

/**
 * completion time = 2023.7.20
 */
public class Solution {
    public int minimumDeleteSum(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        int[][] dp = new int[sLen + 1][tLen + 1];
        // 初始化
        for (int i = 1; i <= sLen; i++) {
            dp[i][0] = dp[i - 1][0] + (int) s.charAt(i - 1);
        }
        for (int i = 1; i <= tLen; i++) {
            dp[0][i] = dp[0][i - 1] + (int) t.charAt(i - 1);
        }
        for (int i = 0; i < sLen; i++) {
            for (int j = 0; j < tLen; j++) {
                if (s.charAt(i) == t.charAt(j)){
                    dp[i+1][j+1] = dp[i][j];
                }else {
                    dp[i+1][j+1] = Math.min(dp[i][j+1]+(int)s.charAt(i),dp[i+1][j]+(int)t.charAt(j));
                }
            }
        }
        return dp[sLen][tLen];
    }
}
