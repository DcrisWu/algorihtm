package TowardsOffer2.day_38_图.code_112_最长递增路径;

/**
 * completion time = 2022.11.17
 */
class Solution {
    private int[][] dp;
    private int[][] matrix;

    public int longestIncreasingPath(int[][] matrix) {
        this.matrix = matrix;
        int m = matrix.length;
        int n = matrix[0].length;
        dp = new int[m][n];
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, dfs(i, j));
            }
        }
        return ans;
    }

    int dfs(int x, int y) {
        if (dp[x][y] != 0) {
            return dp[x][y];
        }
        if (inArea(x - 1, y) && matrix[x][y] < matrix[x - 1][y]) {
            dp[x][y] = Math.max(dp[x][y], dfs(x - 1, y) + 1);
        }
        if (inArea(x + 1, y) && matrix[x][y] < matrix[x + 1][y]) {
            dp[x][y] = Math.max(dp[x][y], dfs(x + 1, y) + 1);
        }
        if (inArea(x, y - 1) && matrix[x][y] < matrix[x][y - 1]) {
            dp[x][y] = Math.max(dp[x][y], dfs(x, y - 1) + 1);
        }
        if (inArea(x, y + 1) && matrix[x][y] < matrix[x][y + 1]) {
            dp[x][y] = Math.max(dp[x][y], dfs(x, y + 1) + 1);
        }
        if (dp[x][y] == 0) {
            dp[x][y] = 1;
        }
        return dp[x][y];
    }

    boolean inArea(int x, int y) {
        return x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length;
    }

    public static void main(String[] args) {
        int[][] arr = {{3, 4, 5}, {3, 2, 6}, {2, 2, 1}};
        Solution solution = new Solution();
        int i = solution.longestIncreasingPath(arr);
        System.out.println(i);
    }
}