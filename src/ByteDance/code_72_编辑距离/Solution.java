package ByteDance.code_72_编辑距离;

class Solution {
    // 删除和添加字符是一样的
    public int minDistance(String s, String t) {
        int m = s.length(), n = t.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= n; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // 删除 p 或者 t 中的一个字符
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
                    // 修改其中一个字符
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + 1);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minDistance("horse", "ros"));
    }
}
