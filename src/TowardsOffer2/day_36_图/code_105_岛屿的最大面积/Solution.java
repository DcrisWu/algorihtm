package TowardsOffer2.day_36_图.code_105_岛屿的最大面积;

/**
 * completion time = 2022.11.15
 */
class Solution {
    private int[][] grid;

    public int maxAreaOfIsland(int[][] grid) {
        this.grid = grid;
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                ans = Math.max(ans, dfs(i, j));
            }
        }
        return ans;
    }

    int dfs(int x, int y) {
        if (!judge(x, y)) {
            return 0;
        }
        int count = 1;
        grid[x][y] = 0;
        count += dfs(x - 1, y);
        count += dfs(x + 1, y);
        count += dfs(x, y - 1);
        count += dfs(x, y + 1);
        return count;
    }

    // 如果该点在范围内，而且没有被访问过，数值为1，就返回true
    boolean judge(int x, int y) {
        return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 1;
    }
}
