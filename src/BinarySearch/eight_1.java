package BinarySearch;

/**
 * 240
 */
public class eight_1 {
    public boolean searchMatrix(int[][] matrix, int target) {
        //使用z字查找法
        int max_x = matrix.length - 1, max_y = matrix[0].length - 1;
        int x = 0, y = max_y;
        while (x <= max_x && y >= 0) {
            if (matrix[x][y] == target) {
                return true;
            } else if (matrix[x][y] < target) {
                x++;
            } else {
                y--;
            }
        }return false;
    }
}
