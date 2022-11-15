package TowardsOffer2.day_36_图.code_107_矩阵中的距离;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * completion time = 2022.11.15
 */
class Solution {

    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] ans = new int[m][n];
        boolean[][] used = new boolean[m][n];
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    ans[i][j] = 0;
                    used[i][j] = true;
                    queue.add(new int[]{i, j});
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];
            if (inArea(x - 1, y, m, n) && !used[x - 1][y]) {
                ans[x - 1][y] = ans[x][y] + 1;
                used[x - 1][y] = true;
                queue.add(new int[]{x - 1, y});
            }
            if (inArea(x + 1, y, m, n) && !used[x + 1][y]) {
                ans[x + 1][y] = ans[x][y] + 1;
                used[x + 1][y] = true;
                queue.add(new int[]{x + 1, y});
            }
            if (inArea(x, y - 1, m, n) && !used[x][y - 1]) {
                ans[x][y - 1] = ans[x][y] + 1;
                used[x][y - 1] = true;
                queue.add(new int[]{x, y - 1});
            }
            if (inArea(x, y + 1, m, n) && !used[x][y + 1]) {
                ans[x][y + 1] = ans[x][y] + 1;
                used[x][y + 1] = true;
                queue.add(new int[]{x, y + 1});
            }
        }
        return ans;
    }

    boolean inArea(int x, int y, int m, int n) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}
