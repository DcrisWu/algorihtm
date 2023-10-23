package ByteDance.code_221_最大正方形;

/**
 * completion time = 2023.8.19
 */
class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int ans = 0;
        int[][] dp = new int[m + 1][n + 1];
        // dp[i][j]表示以matrix[i-1][j-1]为右下角下标的正方形的边长
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    // 取左正方形，上正方形，斜正方形的边的最小值 + 1就是当前dp[i+1][j+1]的值
                    dp[i + 1][j + 1] = Math.min(dp[i][j], Math.min(dp[i + 1][j], dp[i][j + 1])) + 1;
                    ans = Math.max(dp[i + 1][j + 1] * dp[i + 1][j + 1], ans);
                }
            }
        }
        return ans;
    }
}