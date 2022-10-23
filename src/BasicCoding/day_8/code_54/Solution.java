package BasicCoding.day_8.code_54;

import java.util.LinkedList;
import java.util.List;

/**
 * completion time = 2022.10.5
 */
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new LinkedList<>();
        int i = 0, j = 0, m = matrix.length, n = matrix[0].length;
        while (true) {
            if (i > m - i - 1 || j > n - j - 1) {
                break;
            }
            if (i == m - i - 1) {
                for (int k = j; k < n - j; k++) {
                    ans.add(matrix[i][k]);
                }
                break;
            }
            if (j == n - j - 1) {
                for (int k = i; k < m - i; k++) {
                    ans.add(matrix[k][j]);
                }
                break;
            }
            for (int k = j; k < n - j; k++) {
                ans.add(matrix[i][k]);
            }
            for (int k = i + 1; k < m - i; k++) {
                ans.add(matrix[k][n - 1 - j]);
            }
            for (int k = n - j - 2; k >= j; k--) {
                ans.add(matrix[m - 1 - i][k]);
            }
            for (int k = m - i - 2; k > i; k--) {
                ans.add(matrix[k][j]);
            }
            i++;
            j++;

        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arr = {{1,2}, {3,4}};
        System.out.println(solution.spiralOrder(arr));
    }
}
