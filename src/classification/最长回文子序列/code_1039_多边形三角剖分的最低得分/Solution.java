package classification.最长回文子序列.code_1039_多边形三角剖分的最低得分;

/**
 * completion time = 2023.7.30
 */
class Solution {
    /**
     * 对于多边形一对相邻的顶点i,j来说，选择一个顶点，然后就可以拆分成子问题
     * f(i, j) = min(f(i, k),f(k, j)), k for i+1 to j-1，k一定要存在
     * j 倒序遍历，i 正序遍历
     */
    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        int[][] dp = new int[n][n];
        for (int i = n - 3; i >= 0; i--) {
            for (int j = i + 2; j < n; j++) {
                int temp = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; k++) {
                    temp = Math.min(temp, dp[i][k] + dp[k][j] + values[i] * values[k] * values[j]);
                }
                dp[i][j] = temp;
            }
        }
        return dp[0][n-1];
    }
}
