package classification.最长回文子序列.code_516_最长回文子序列;

/**
 * completion time = 2023.7.30
 */
class Solution {
    /*
    f(i,j) = f(i+1,j-1)+2, s[i] == s[j]
    f(i,j) = max(f(i+1,j), f(i,j-1)), s[i] != s[j]
    用递推表示，因为要先获取到i+1才可以算i，所以i要倒序遍历，同理，j要正序遍历
     */
    public int longestPalindromeSubseq(String s) {
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
        return dp[0][n - 1];
    }
}