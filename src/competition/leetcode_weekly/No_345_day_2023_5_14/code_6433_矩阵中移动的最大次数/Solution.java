package competition.leetcode_weekly.No_345_day_2023_5_14.code_6433_矩阵中移动的最大次数;

/**
 * completion time = 2023.5.14
 */
class Solution {
    public int maxMoves(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] walk = new boolean[m][n];
        boolean canbegin = false;
        for (int i = 0; i < m; i++) {
            if ((i - 1 >= 0 && grid[i - 1][1] > grid[i][0]) || (grid[i][1] > grid[i][0]) || (i + 1 < m && grid[i + 1][1] > grid[i][0])) {
                walk[i][0] = true;
                canbegin = true;
            }
        }
        if (!canbegin){
            return 0;
        }
        int deepth = 0;
        // 外部按照列遍历
        for (int i = 1; i < n; i++) {
            // 遍历每一行
            int before = deepth;
            for (int j = 0; j < m; j++) {
                if ((j - 1 >= 0 && grid[j][i] > grid[j - 1][i - 1] && walk[j - 1][i - 1]) ||
                        (grid[j][i] > grid[j][i - 1] && walk[j][i - 1]) ||
                        (j + 1 < m && grid[j][i] > grid[j + 1][i - 1]) && walk[j + 1][i - 1]) {
                    walk[j][i] = true;
                    deepth = before + 1;
                }
            }
            if (before == deepth) {
                break;
            }
        }
        return deepth;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arr = {{2, 4, 3, 5}, {5, 4, 9, 3}, {3, 4, 2, 11}, {10, 9, 13, 15}};
        System.out.println(solution.maxMoves(arr));
    }
}
