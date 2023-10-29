package ByteDance.code_695_岛屿的最大面积;

/**
 * completion time = 2023.10.29
 */
class Solution {

    private boolean[][] visit;
    private int[][] grid;
    private int[][] change = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int maxAreaOfIsland(int[][] grid) {
        this.grid = grid;
        visit = new boolean[grid.length][grid[0].length];
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (check(i, j)) {
                    ans = Math.max(ans, dfs(i, j));
                }
            }
        }
        return ans;
    }

    int dfs(int i, int j) {
        int sum = 1;
        visit[i][j] = true;
        for (int[] ch : change) {
            int x = i + ch[0];
            int y = j + ch[1];
            if (check(x, y)) {
                sum += dfs(x, y);
            }
        }
        return sum;
    }

    boolean check(int i, int j) {
        return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && !visit[i][j] && grid[i][j] == 1;
    }
}
