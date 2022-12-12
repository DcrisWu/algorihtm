package ByteDance.code_51_N皇后;

import java.util.ArrayList;
import java.util.List;

/**
 * completion time = 2022.12.10
 */
class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] dp = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = '.';
            }
        }
        List<List<String>> ans = new ArrayList<>();
        backTrack(ans,dp,0);
        return ans;
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

    void backTrack(List<List<String>> ans, char[][] dp, int row) {
        if (row >= dp.length) {
            List<String> part = new ArrayList<>();
            for (char[] chars : dp) {
                part.add(new String(chars));
            }
            ans.add(part);
        }
        for (int i = 0; i < dp.length; i++) {
            if (ifAllowInsert(dp, row, i)) {
                dp[row][i] = 'Q';
                backTrack(ans, dp, row + 1);
                dp[row][i] = '.';
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solveNQueens(4));
    }
}