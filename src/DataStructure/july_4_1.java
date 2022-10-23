package DataStructure;

public class july_4_1 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m_row = matrix.length - 1;
        int m_column = matrix[0].length - 1;
        int row = 0;
        int column = 0;
        while (matrix[row][column] < target && row < m_row - 1 && column < m_column - 1) {
            row++;
            column++;
        }
        while (matrix[row][column] < target && column < m_column - 1) {
            column++;
        }
        while (matrix[row][column] < target && row < m_row - 1) {
            row++;
        }
        for (int r = row; r >= 0; r--) {
            if (matrix[r][column] == target) {
                return true;
            }
            if (matrix[r][column] < target) {
                break;
            }
        }
        for (int i = row; i >= 0; i--) {
            for (int j = column; j <= m_column; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }
        for (int i = row; i <= m_row; i++) {
            for (int j = column; j >= 0; j--) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }
        return false;

    }

    public boolean searchMatrix2(int[][] matrix, int target) {
        //Z字查找法，先从右上角开始查找
        int m_row = matrix.length, m_column = matrix[0].length;
        int x = 0, y = m_column - 1;
        while (x < m_row && y >= 0){
            if(matrix[x][y] == target){
                return true;
            }
            //如果当前位置小于target，因为y是最大的，所以只能x增大
            if(matrix[x][y] < target){
                x++;
            }else {
                //此时(x,y) > target，所以不能增大x了，此时y只能减小了
                y--;
            }

        }
        return false;
    }
}
