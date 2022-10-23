package BinarySearch;

/**
 * code_1292
 */
public class fifteen_1 {
    public static void main(String[] args) {
        int[][] arr = {{1, 1, 3, 2, 4, 3, 2}, {1, 1, 3, 2, 4, 3, 2}, {1, 1, 3, 2, 4, 3, 2}};
        fifteen_1 fifteen_1 = new fifteen_1();
        System.out.println(fifteen_1.maxSideLength(arr, 1));
    }

    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length, n = mat[0].length;
        int[][] preSum = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                preSum[i][j] = preSum[i - 1][j] + preSum[i][j - 1] - preSum[i - 1][j - 1] + mat[i - 1][j - 1];
            }
        }
        int l = 1, r = Math.min(m, n), ans = 0;
        while (l <= r) {
            int mid = (l + r) >> 1;
            boolean find = false;
            for (int i = 1; i <= m - mid + 1; i++) {
                for (int j = 1; j <= n - mid + 1; j++) {
                    if (cal(preSum, i, j, i + mid - 1, j + mid - 1) <= threshold) {
                        find = true;
                    }
                }
            }
            if (find) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }

        }
        return ans;
    }

    public int cal(int[][] preSum, int l_x, int l_y, int r_x, int r_y) {
        return preSum[r_x][r_y] - preSum[l_x - 1][r_y] - preSum[r_x][l_y - 1] + preSum[l_x - 1][l_y - 1];
    }

}
