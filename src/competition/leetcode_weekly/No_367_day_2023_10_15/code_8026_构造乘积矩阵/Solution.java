package competition.leetcode_weekly.No_367_day_2023_10_15.code_8026_构造乘积矩阵;

/**
 * completion time = 2023.10.15
 */
class Solution {

    private int mod = 12345;

    public int[][] constructProductMatrix(int[][] grid) {
        long all = 1L;
        int m = grid.length, n = grid[0].length;
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans[i][j] = (int) all;
                all = all * grid[i][j] % mod;
            }
        }
        all = 1;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                ans[i][j] = (int) (ans[i][j] * all % mod);
                all = all * grid[i][j] % mod;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 2}, {3, 4}};
        int[][] ints = new Solution().constructProductMatrix(arr);
        System.out.println(ints);
    }
}