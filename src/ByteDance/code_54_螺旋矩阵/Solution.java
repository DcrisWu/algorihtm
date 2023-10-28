package ByteDance.code_54_螺旋矩阵;

import java.util.ArrayList;
import java.util.List;

/**
 * completion time = 2023.10.28
 */
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int minx = 0, miny = 0, maxx = matrix.length - 1, maxy = matrix[0].length - 1;
        List<Integer> res = new ArrayList<>();
        // 每遍历一行，就要对最大值，最小值进行更新，每次遍历的时候，要判断是否合法
        while (minx <= maxx && miny <= maxy) {
            for (int i = miny; i <= maxy && minx <= maxx; i++) {
                res.add(matrix[minx][i]);
            }
            minx++;
            for (int i = minx; i <= maxx && miny <= maxy; i++) {
                res.add(matrix[i][maxy]);
            }
            maxy--;
            for (int i = maxy; i >= miny && minx <= maxx; i--) {
                res.add(matrix[maxx][i]);
            }
            maxx--;
            for (int i = maxx; i >= minx && miny <= maxy; i--) {
                res.add(matrix[i][miny]);
            }
            miny++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        for (Integer i : new Solution().spiralOrder(arr)) {
            System.out.println(i);
        }
    }
}
