package competition.leetcode_weekly.No_343_day_2023_4_30.code_6342_找出叠涂元素;

import java.util.HashMap;
import java.util.Map;

/**
 * completion time = 2023.4.30
 */
class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[] row = new int[m];
        int[] col = new int[n];
        // mat中一个数对应的下标
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map.put(mat[i][j], new int[]{i, j});
            }
        }
        for (int i = 0; i < arr.length; i++) {
            int[] ints = map.get(arr[i]);
            int x = ints[0];
            int y = ints[1];
            row[x] += 1;
            col[y] += 1;
            if (row[x] == n || col[y] == m) {
                return i;
            }
        }
        return 0;
    }

}