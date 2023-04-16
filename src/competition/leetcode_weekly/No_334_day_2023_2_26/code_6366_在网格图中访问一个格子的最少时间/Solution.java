package competition.leetcode_weekly.No_334_day_2023_2_26.code_6366_在网格图中访问一个格子的最少时间;

/**
 * unComplete
 */
class Solution {
    private boolean[][] mark;

    public int minimumTime(int[][] grid) {
        mark = new boolean[grid.length][grid[0].length];
        int dfs = dfs(grid, 0, 0, 0, false);
        return dfs == -1 ? -1 : dfs + 1;
    }

    int dfs(int[][] grid, int used, int x, int y, boolean canBackTrack) {
        if (x == grid.length - 1 && y == grid[0].length - 1) {
            return used;
        }
        int res = -1;
        mark[x][y] = true;
        if (isAllow(grid, x + 1, y)) {
            int cost = grid[x + 1][y] - used;
            if (cost <= 1) {
                int dfs = dfs(grid, used + 1, x + 1, y, true);
                if (res == -1) {
                    res = dfs;
                } else {
                    res = Math.min(res, dfs);
                }
            } else if (canBackTrack) {
                int plus = cost % 2 == 0 ? cost : cost + 1;
                int dfs = dfs(grid, used + plus, x + 1, y, true);
                if (res == -1) {
                    res = dfs;
                } else {
                    res = Math.min(res, dfs);
                }
            }
        }
        if (isAllow(grid, x - 1, y)) {
            int cost = grid[x - 1][y] - used;
            if (cost <= 1) {
                int dfs = dfs(grid, used + 1, x - 1, y, true);
                if (res == -1) {
                    res = dfs;
                } else {
                    res = Math.min(res, dfs);
                }
            } else if (canBackTrack) {
                int plus = cost % 2 == 0 ? cost : cost + 1;
                int dfs = dfs(grid, used + plus, x - 1, y, true);
                if (res == -1) {
                    res = dfs;
                } else {
                    res = Math.min(res, dfs);
                }
            }
        }
        if (isAllow(grid, x, y + 1)) {
            int cost = grid[x][y + 1] - used;
            if (cost <= 1) {
                int dfs = dfs(grid, used + 1, x, y + 1, true);
                if (res == -1) {
                    res = dfs;
                } else {
                    res = Math.min(res, dfs);
                }
            } else if (canBackTrack) {
                int plus = cost % 2 == 0 ? cost : cost + 1;
                int dfs = dfs(grid, used + plus, x, y + 1, true);
                if (res == -1) {
                    res = dfs;
                } else {
                    res = Math.min(res, dfs);
                }
            }
        }
        if (isAllow(grid, x, y - 1)) {
            int cost = grid[x][y - 1] - used;
            if (cost <= 1) {
                int dfs = dfs(grid, used + 1, x, y - 1, true);
                if (res == -1) {
                    res = dfs;
                } else {
                    res = Math.min(res, dfs);
                }
            } else if (canBackTrack) {
                int plus = cost % 2 == 0 ? cost : cost + 1;
                int dfs = dfs(grid, used + plus, x, y - 1, true);
                if (res == -1) {
                    res = dfs;
                } else {
                    res = Math.min(res, dfs);
                }
            }
        }
        mark[x][y] = false;
        return res;
    }

    boolean isAllow(int[][] grid, int x, int y) {
        return x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && !mark[x][y];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] grid = {{0, 1, 3, 2}, {5, 1, 2, 5}, {4, 3, 8, 6}};
        System.out.println(solution.minimumTime(grid));
    }
}
