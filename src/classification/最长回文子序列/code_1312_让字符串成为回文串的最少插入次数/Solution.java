package classification.最长回文子序列.code_1312_让字符串成为回文串的最少插入次数;

/**
 * completion time = 2023.7.30
 */
class Solution {
    // 在一边插入，相当于在另一边删除，转化为删除问题，字符串长度 - 获得的最长的回文子序列 = 答案
    // s[i,j] = s[i+1,j-1]+2 ,s[i] == s[j]
    // s[i,j] = max(s[i+1, j],s[i, j-1]), s[i] != s[j]
    // i倒序，j正序
    public int minInsertions(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return n - dp[0][n - 1];
    }
}