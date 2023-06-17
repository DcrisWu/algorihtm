package competition.leetcode_weekly.No_348_day_2023_6_4.code_2718_查询后矩阵的和;

import java.util.HashSet;
import java.util.Set;

/**
 * completion time = 2023.6.8
 *
 * tips:
 * 1. 矩阵中的元素，之后最后一次修改有关，所以对于每个matrix[i][j]，只需要考虑最后一次修改的情况即可
 * 2. 从后往前遍历，如果当前row/col已经被修改过，则跳过
 * 3. 如果当前row/col没有被修改过，则计算当前row/col的和
 */
class Solution {
    public long matrixSumQueries(int n, int[][] queries) {
        Set<Integer> row = new HashSet<>();
        Set<Integer> col = new HashSet<>();
        long res = 0;
        for (int i = queries.length - 1; i >= 0; i--) {
            int[] query = queries[i];
            int type = query[0];
            int index = query[1];
            int value = query[2];
            if (type == 0) {
                if (row.contains(index)) {
                    continue;
                }
                row.add(index);
                res += (long) (n - col.size()) * value;
            } else {
                if (col.contains(index)) {
                    continue;
                }
                col.add(index);
                res += (long) (n - row.size()) * value;
            }
        }
        return res;
    }
}
