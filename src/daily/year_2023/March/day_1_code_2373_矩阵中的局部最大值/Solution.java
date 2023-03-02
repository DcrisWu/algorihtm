package daily.year_2023.March.day_1_code_2373_矩阵中的局部最大值;

/**
 * completion time = 2023.3.1
 */
class Solution {
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] ans = new int[n - 2][n - 2];
        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < n - 2; j++) {
                ans[i][j] = findMax(grid, i + 1, j + 1);
            }
        }
        return ans;
    }

    int findMax(int[][] grid, int x, int y) {
        int max = grid[x][y];
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                max = Math.max(max, grid[i][j]);
            }
        }
        return max;
    }
}
