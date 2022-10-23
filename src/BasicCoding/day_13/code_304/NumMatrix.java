package BasicCoding.day_13.code_304;

/**
 * completion time = 2022.10.8
 */
public class NumMatrix {
    private int[][] sum;

    public NumMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        sum = new int[m][n];
        sum[0][0] = matrix[0][0];
        for (int i = 1; i < m; i++) {
            sum[i][0] = matrix[i][0] + sum[i - 1][0];
        }
        for (int i = 1; i < n; i++) {
            sum[0][i] = matrix[0][i] + sum[0][i - 1];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + matrix[i][j];
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(sum[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int maxSum = sum[row2][col2];
        int left = 0;
        int up = 0;
        int minSum = 0;
        if (row1 != 0) {
            up = sum[row1 - 1][col2];
        }
        if (col1 != 0) {
            left = sum[row2][col1 - 1];
        }
        if (col1 != 0 && row1 != 0) {
            minSum = sum[row1 - 1][col1 - 1];
        }
        return maxSum - left - up + minSum;
    }
}
