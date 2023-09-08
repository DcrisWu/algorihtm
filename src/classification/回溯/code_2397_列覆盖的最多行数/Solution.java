package classification.回溯.code_2397_列覆盖的最多行数;

/**
 * completion time = 2023.9.8
 */
class Solution {

    private int[][] matrix;
    private int[] row;
    private int ans = 0;

    private int numSelect;

    public int maximumRows(int[][] matrix, int numSelect) {
        this.matrix = matrix;
        this.numSelect = numSelect;
        row = new int[matrix.length];
        int[] used = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int m : matrix[i]) {
                if (m == 1) {
                    row[i]++;
                }
            }
        }
        recursive(0,0,used);
        return ans;
    }

    void recursive(int i, int select, int[] used) {
        if (i == matrix[0].length) {
            if (select == numSelect) {
                ans = Math.max(ans, count(used));
            }
            return;
        }
        // 选择第 i 列
        for (int r = 0; r < matrix.length; r++) {
            if (matrix[r][i] == 1) {
                used[r]++;
            }
        }
        recursive(i + 1, select + 1, used);
        for (int r = 0; r < matrix.length; r++) {
            if (matrix[r][i] == 1) {
                used[r]--;
            }
        }
        recursive(i + 1, select, used);
    }

    int count(int[] used) {
        int count = 0;
        for (int i = 0; i < used.length; i++) {
            if (used[i] >= row[i]) {
                count++;
            }
        }
        return count;
    }
}
