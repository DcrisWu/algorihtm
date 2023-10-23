package ByteDance.code_10_正则表达式匹配;

/**
 * completion time = 2023.10.23
 */
class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        // dp[0][0]表示空字符串
        dp[0][0] = true;
        // 初始化*，因为*前面肯定有字符，需要初始化s为空时的匹配情况
        for (int i = 1; i <= n; i++) {
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = dp[0][i - 2];
            }
        }
        // 出现 *
        //
        // dp[i][j] == dp[i-1][j-2], if s[i] = p[j-1]
        // dp[i][j] == dp[i-2][j-2], if s[i-1] = s[i] = p[j-1]
        // dp[i][j] == dp[i-3][j-2], if s[i-2] = s[i-1] = s[i] = p[j-1]
        // ...
        // 如果我们通过这种方法进行转移，那么我们就需要枚举这个组合到底匹配了 sss 中的几个字符，会增导致时间复杂度增加，并且代码编写起来十分麻烦。
        // 我们不妨换个角度考虑这个问题：字母 + 星号的组合在匹配的过程中，本质上只会有两种情况：
        //
        //1. 匹配 s 末尾的一个字符，将该字符扔掉，而该组合还可以继续进行匹配；
        //
        //2. 不匹配字符，将该组合扔掉，不再进行匹配。
        //
        //
        // if (s.charAt(i - 1) == p.charAt(j - 2))
        // dp[i][j] == dp[i-1][j-2]，此时*使得字符多出现一次
        // dp[i-1][j-2] = dp[i-1][j]，因为当 p.charAt(j-1) == '*'时，可以把 p.charAt(j-2)消掉，
        // 那么dp[i-1][j] = dp[i-1][j-2]，又因为这些操作都是在dp[i][j]之前完成的，所以可以直接使用dp[i-1][j]
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 2];
                    if (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') {
                        dp[i][j] |= dp[i - 1][j];
                    }
                } else if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
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