package TowardsOffers2.code_29_顺时针打印矩阵;

class Solution {

    private int[] ans;
    private int begin = 0;

    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0){
            return new int[]{};
        }
        int m = matrix.length;
        int n = matrix[0].length;
        ans = new int[m * n];
        int left_x = 0, up_y = 0, right_x = n - 1, down_y = m - 1;
        while (left_x <= right_x && up_y <= down_y) {
            print(matrix, left_x, up_y, right_x, down_y);
            left_x++;
            right_x--;
            up_y++;
            down_y--;
        }
        return ans;
    }

    void print(int[][] matrix, int left_x, int up_y, int right_x, int down_y) {
        for (int i = left_x; i <= right_x; i++) {
            ans[begin++] = matrix[up_y][i];
        }
        if (begin == ans.length){
            return;
        }
        for (int i = up_y + 1; i <= down_y; i++) {
            ans[begin++] = matrix[i][right_x];
        }
        if (begin == ans.length){
            return;
        }
        for (int i = right_x - 1; i >= left_x; i--) {
            ans[begin++] = matrix[down_y][i];
        }
        if (begin == ans.length){
            return;
        }
        for (int i = down_y - 1; i > up_y; i--) {
            ans[begin++] = matrix[i][left_x];
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arr = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        System.out.println(solution.spiralOrder(arr));
    }
}
