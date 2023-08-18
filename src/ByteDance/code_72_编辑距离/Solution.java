package ByteDance.code_72_编辑距离;

class Solution {
    // 删除和添加字符是一样的
    public int minDistance(String s, String t) {
        int slen = s.length();
        int tlen = t.length();
        int[][] dp = new int[slen + 1][tlen + 1];
        for (int i = 0; i <= slen; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= tlen; i++) {
            dp[0][i] = i;
        }
        for (int i = 0; i < slen; i++) {
            for (int j = 0; j < tlen; j++) {
                if (s.charAt(i) == t.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j];
                } else {
                    // 删除的代价
                    dp[i + 1][j + 1] = Math.min(dp[i + 1][j], dp[i][j + 1]) + 1;
                    // 修改的代价
                    dp[i + 1][j + 1] = Math.min(dp[i + 1][j + 1], dp[i][j] + 1);
                }
            }
        }
        return dp[slen][tlen];
    }
}
