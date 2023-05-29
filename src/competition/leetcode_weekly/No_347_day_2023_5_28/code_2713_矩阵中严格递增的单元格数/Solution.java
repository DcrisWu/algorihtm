package competition.leetcode_weekly.No_347_day_2023_5_28.code_2713_矩阵中严格递增的单元格数;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * completion time = 2023.5.29
 */
class Solution {
    public int maxIncreasingCells(int[][] mat) {
        TreeMap<Integer, List<int[]>> map = new TreeMap<>();
        int m = mat.length;
        int n = mat[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map.computeIfAbsent(mat[i][j], e -> new ArrayList<>()).add(new int[]{i, j});
            }
        }
        int res = 0;
        int[][] mx = new int[m][n];
        int[] rowMax = new int[m];
        int[] colMax = new int[n];
        for (Integer key : map.keySet()) {
            // 先把最大值算出来，再更新 rowMax 和 colMax
            // 第一遍先更新从previous的最大值到当前位置，走的步数的最大值
            for (int[] ints : map.get(key)) {
                int x = ints[0], y = ints[1];
                mx[x][y] = Math.max(rowMax[x], colMax[y]) + 1;
                res = Math.max(mx[x][y], res);
            }
            // 不可以在第一遍就更新了行和列的最大值，因为会影响下一步的mx
            // 在第二轮遍历中，更新第x行和第y列的最大值
            for (int[] ints : map.get(key)) {
                int x = ints[0], y = ints[1];
                rowMax[x] = Math.max(rowMax[x], mx[x][y]);
                colMax[y] = Math.max(colMax[y], mx[x][y]);
            }
        }
        return res;
    }
}