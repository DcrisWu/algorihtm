package classification.区间DP.code_1771_由子序列构造的最长回文串的长度;

/**
 * completion time = 2023.7.31
 */
class Solution {
    public int longestPalindrome(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        // s表示word1+word2
        // f(i,j) = f(i+1,j-1)+2, s[i] == s[j]
        // f(i,j) = max(f(i,j-1),f(i+1,j)),s[i] != s[j]
        // 因为word1和word2中必须是非空子序列，只能将有取到word1和word2时候，记录取得的最大值
        String s = word1 + word2;
        int ans = 0;
        int[][] dp = new int[m + n][m + n];
        for (int i = m + n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < m + n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                    if (i < m && j >= m) {
                        ans = Math.max(ans, dp[i][j]);
                    }
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return ans;
    }
}