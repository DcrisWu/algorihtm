package ByteDance.code_44_通配符匹配;

/**
 * completion time = 2023.10.23
 */
class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            // * 能匹配任意字符的前提是，前面是匹配的，所以如果出现不是*，就直接break就好了
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = true;
            } else {
                break;
            }
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '*') {
                    // 判断时候记住匹配 0个 和匹配 多个 的区别
                    // dp[i][j-1]表示 * 匹配 0 个字符
                    // dp[i-1][j]表示 * 匹配 >= 1个字符，那么相当于将 s.charAt(i)消掉，结果就等于dp[i-1][j]，因为dp[i-1][j]也等于dp[i-2][j]，可以一直这样地推过来
                    // 因为这里的 * 不需要看前面的字符，所以不需要对 s.charAt(i-1) 和 p.charAt(j-2)进行判断
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                } else if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        return dp[m][n];
    }
}
