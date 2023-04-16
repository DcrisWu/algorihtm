package competition.leetcode_weekly.No_337_day_2023_3_19.code_6322_检查骑士巡视方案;

/**
 * completion time = 2023.3.19
 */
class Solution {

    private int[][] grid;
    private int n;

    public boolean checkValidGrid(int[][] grid) {
        this.grid = grid;
        n = grid.length;
        if (grid[0][0] != 0){
            return false;
        }
        return backTrack(0,0);
    }

    // （x,y）是出发点，已经走过
    boolean backTrack(int x, int y) {
        if (grid[x][y] == n * n - 1) {
            return true;
        }
        if (ifMove(x + 1, y + 2, grid[x][y])) {
            return backTrack(x + 1, y + 2);
        }
        if (ifMove(x + 1, y - 2, grid[x][y])) {
            return backTrack(x + 1, y - 2);
        }
        if (ifMove(x - 1, y + 2, grid[x][y])) {
            return backTrack(x - 1, y + 2);
        }
        if (ifMove(x - 1, y - 2, grid[x][y])) {
            return backTrack(x - 1, y - 2);
        }
        if (ifMove(x + 2, y + 1, grid[x][y])) {
            return backTrack(x + 2, y + 1);
        }
        if (ifMove(x + 2, y - 1, grid[x][y])) {
            return backTrack(x + 2, y - 1);
        }
        if (ifMove(x - 2, y + 1, grid[x][y])) {
            return backTrack(x - 2, y + 1);
        }
        if (ifMove(x - 2, y - 1, grid[x][y])) {
            return backTrack(x - 2, y - 1);
        }
        return false;
    }

    boolean ifMove(int x, int y, int before) {
        return x >= 0 && x < n && y >= 0 && y < n && grid[x][y] == before + 1;
    }

    public static void main(String[] args) {
        int[][] arr = {{24, 11, 22, 17, 4}, {21, 16, 5, 12, 9}, {6, 23, 10, 3, 18}, {15, 20, 1, 8, 13}, {0, 7, 14, 19, 2}};
        Solution solution = new Solution();
        System.out.println(solution.checkValidGrid(arr));
    }
}
