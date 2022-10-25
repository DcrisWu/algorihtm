package TowardsOffer2.day_13_单调栈.code_040_矩阵中最大的矩形;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * completion time = 2022.10.24
 */
class Solution {
    public int maximalRectangle(String[] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return 0;
        }
        int n = matrix[0].length();
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i].charAt(j) == '1') {
                    dp[i][j] = j == 0 ? 1 : dp[i][j - 1] + 1;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            // 寻找宽为dp[i][j]的长方形的最长高
            int[] up = new int[m];
            int[] down = new int[m];

            Deque<Integer> stack = new ArrayDeque<>();
            for (int j = 0; j < m; j++) {
                if (dp[j][i] == 0) {
                    stack.push(j);
                    continue;
                }
                while (!stack.isEmpty() && dp[stack.peek()][i] >= dp[j][i]) {
                    stack.pop();
                }
                up[j] = stack.isEmpty() ? -1 : stack.peek();
                stack.push(j);
            }
            stack.clear();
            for (int j = m - 1; j >= 0; j--) {
                if (dp[j][i] == 0) {
                    stack.push(j);
                    continue;
                }
                while (!stack.isEmpty() && dp[stack.peek()][i] >= dp[j][i]) {
                    stack.pop();
                }
                down[j] = stack.isEmpty() ? m : stack.peek();
                stack.push(j);
            }

            for (int j = 0; j < m; j++) {
                ans = Math.max(ans, dp[j][i] * (down[j] - up[j] - 1));
            }
        }
        return ans;
    }

}