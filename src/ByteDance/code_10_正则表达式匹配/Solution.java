package ByteDance.code_10_正则表达式匹配;

/**
 *
 */
class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        // dp[0][0]表示空字符串
        dp[0][0] = true;
        // 初始化*，因为*前面肯定有字符，需要初始化s为空时的匹配情况
        for (int i = 2; i <= n; i++) {
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = dp[0][i - 2];
            }
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '*') {
                    // a*消掉
                    if (dp[i][j - 2]) {
                        dp[i][j] = true;
                    } else if (s.charAt(i - 1) == p.charAt(j - 2)) {
                        // * -> " "
                        // 记住这里是dp[i-1][j]，记住就好了
                        dp[i][j] = dp[i - 1][j];
                    } else if (p.charAt(j - 2) == '.') {
                        // 记住这里是dp[i-1][j]，记住就好了
                        dp[i][j] = dp[i - 1][j];
                    }
                } else {
                    if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                        // * -> " "
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isMatch("baa", "ba*"));
    }
}