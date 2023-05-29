package competition.leetcode_weekly.No_347_day_2023_5_28.code_6440_对角线上不同值的数量差;

import java.util.HashSet;
import java.util.Set;

/**
 * completion time = 2023.5.29
 */
class Solution {
    public int[][] differenceOfDistinctValues(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans[i][j] = cal(grid, m, n, i, j);
            }
        }
        return ans;
    }

    int cal(int[][] grid, int m, int n, int i, int j) {
        int x = i - 1, y = j - 1;
        Set<Integer> set = new HashSet<>();
        while (x >= 0 && y >= 0) {
            set.add(grid[x][y]);
            x--;
            y--;
        }
        int topLeft = set.size();
        set.clear();
        x = i + 1;
        y = j + 1;
        while (x < m && y < n) {
            set.add(grid[x][y]);
            x++;
            y++;
        }
        return Math.abs(topLeft - set.size());
    }
}
