package ByteDance.code_221_最大正方形;

/**
 * completion time = 2023.8.19
 */
class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m + 1][n + 1];
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    // dp[i + 1][j]保证了上面的边，dp[i][j + 1]保证了左边的边，dp[i][j]保证了斜边
                    // 以上三个值取最小值，保证了一定是个正方形
                    dp[i + 1][j + 1] = Math.min(dp[i][j], Math.min(dp[i + 1][j], dp[i][j + 1])) + 1;
                    ans = Math.max(ans,dp[i + 1][j + 1] * dp[i + 1][j + 1]);
                }
            }
        }
        return ans;
    }
}