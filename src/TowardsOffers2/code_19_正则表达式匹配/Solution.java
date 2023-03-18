package TowardsOffers2.code_19_正则表达式匹配;

/**
 * completion time = 2023.3.18
 */
class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        // 要先初始化 s 和 p 都是空串时候的dp，作为基础条件
        // 因为dp跟上一个元素有关，s 和 p 都是空串时候，dp[0][0]为true
        dp[0][0] = true;
        // s 为空串，但 p 不为空串，要想匹配，只可能是右端是 *，它干掉一个字符后，把 p 变为空串
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }
        // 正常的遍历流程
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 如果p[j-1] == '*'，则有三种情况:
                // 1. * 消掉它左边的字符 dp[i][j] |= dp[i][j-2]
                // 2. * 不表示任何字符，相当于一个空串 dp[i][j] |= dp[i][j-1]
                // 3. * 表示它左边的字符，如果 s[i-1] 与 p[j-2]匹配的话, dp[i][j] |= dp[i-1][j-1]
                // 情况1和情况2都是无条件成立的，情况3需要字符匹配才可以使用
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 2] || dp[i][j - 1];
                    if (match(s, p, i, j - 1)) {
                        dp[i][j] |= dp[i - 1][j];
                    }
                } else {
                    // 看s[i-1] 和 p[j-1] 是否匹配，匹配 && dp[i-1][j-1] 才为true
                    dp[i][j] = dp[i - 1][j - 1] && match(s, p, i, j);
                }
            }
        }
        return dp[m][n];
    }

    // 当 s[i-1] == p[j-1] || p[j-1] == '。' 时候，返回true
    boolean match(String s, String p, int i, int j) {
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isMatch("aab", "c*a*b"));
    }
}