package basicAlgorithm.day_8.code_1091;

import java.awt.*;
import java.util.ArrayDeque;
import java.util.Queue;

/**
 * completion time = 2022.9.20
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arr = {{0,0,0},{1,1,0},{1,1,0}};
        System.out.println(solution.shortestPathBinaryMatrix(arr));
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] != 0 || grid[grid.length - 1][grid[0].length - 1] != 0) {
            return -1;
        }
        if (grid.length == 1) {
            return 1;
        }
        Queue<Point> queue = new ArrayDeque<>();
        grid[0][0] = -1;
        queue.add(new Point(0, 0));
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                Point head = queue.poll();
                int row = head.x, column = head.y;
                if (inArea(grid, row - 1, column - 1)) {
                    grid[row - 1][column - 1] = grid[row][column] - 1;
                    queue.add(new Point(row - 1, column - 1));
                }
                if (inArea(grid, row - 1, column)) {
                    grid[row - 1][column] = grid[row][column] - 1;
                    queue.add(new Point(row - 1, column));
                }
                if (inArea(grid, row - 1, column + 1)) {
                    grid[row - 1][column + 1] = grid[row][column] - 1;
                    queue.add(new Point(row - 1, column + 1));
                }
                if (inArea(grid, row, column - 1)) {
                    grid[row][column - 1] = grid[row][column] - 1;
                    queue.add(new Point(row, column - 1));
                }
                if (inArea(grid, row, column + 1)) {
                    grid[row][column + 1] = grid[row][column] - 1;
                    queue.add(new Point(row, column + 1));
                }
                if (inArea(grid, row + 1, column - 1)) {
                    grid[row + 1][column - 1] = grid[row][column] - 1;
                    queue.add(new Point(row + 1, column - 1));
                }
                if (inArea(grid, row + 1, column)) {
                    grid[row + 1][column] = grid[row][column] - 1;
                    queue.add(new Point(row + 1, column));
                }
                if (inArea(grid, row + 1, column + 1)) {
                    grid[row + 1][column + 1] = grid[row][column] - 1;
                    queue.add(new Point(row + 1, column + 1));
                }
            }
            if (grid[grid.length - 1][grid[0].length - 1] != 0) {
                return -grid[grid.length - 1][grid[0].length - 1];
            }
        }
        return -1;
    }

    public boolean inArea(int[][] grid, int r, int c) {
        return r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] == 0;
    }
}
