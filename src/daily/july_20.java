package daily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class july_20 {
    public static List<List<Integer>> shiftGrid(int[][] grid, int k) {
        for (int t = 0; t < k; t++) {
            int m = grid.length;
            int n = grid[0].length;
            int[] temp = new int[m];
            for (int i = 0; i < m; i++) {
                temp[i] = grid[i][n - 1];
            }
            for (int i = m - 1; i >= 0; i--) {
                System.arraycopy(grid[i], 0, grid[i], 1, n - 1);
            }
            for (int i = 1; i < m; i++) {
                grid[i][0] = temp[i - 1];
            }
            grid[0][0] = temp[m - 1];
        }
        List<List<Integer>> ans = new ArrayList<>();

        for (int[] ints : grid) {
            List<Integer> integers = new ArrayList<>();
            for (int anInt : ints) {
                integers.add(anInt);
            }
            ans.add(integers);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        shiftGrid(arr, 1);
    }
}
