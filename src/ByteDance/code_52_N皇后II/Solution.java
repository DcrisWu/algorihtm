package ByteDance.code_52_N皇后II;

/**
 * completion time = 2022.12.10
 */
class Solution {
    private int re = 0;
    public int totalNQueens(int n) {
        char[][] dp = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = '.';
            }
        }
        backTrack(dp, 0);
        return re;
    }

    boolean ifAllowInsert(char[][] dp, int row, int col) {
        for (int i = row - 1; i >= 0; i--) {
            if (dp[i][col] == 'Q') {
                return false;
            }
        }
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (dp[i][j] == 'Q') {
                return false;
            }
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j < dp.length; i--, j++) {
            if (dp[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    void backTrack(char[][] dp, int row) {
        if (row >= dp.length) {
            re++;
        }
        for (int i = 0; i < dp.length; i++) {
            if (ifAllowInsert(dp, row, i)) {
                dp[row][i] = 'Q';
                backTrack(dp, row + 1);
                dp[row][i] = '.';
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.totalNQueens(4));
    }
}