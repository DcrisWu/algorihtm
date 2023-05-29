package basicAlgorithm.day_1.code_74;

/**
 * completion time = 2022.9.15
 */
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int row = 0, l = 0, r = m - 1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (target <= matrix[mid][n - 1]) {
                row = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        if(matrix[row][n-1] < target){
            return false;
        }
        l = 0;
        r = n - 1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (matrix[row][mid] == target) {
                return true;
            }
            if (matrix[row][mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return false;
    }
}
