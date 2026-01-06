package daily.year_2026.January.day_5_code_1975_最大方阵和;

class Solution {
    // 对于两个负数，一定有办法变为都是正数
    // 对于一负一正，一定有办法把其中一个变为负数，另一个变为正数
    // 如果存在0，那么所有负数都可以变为正数
    public long maxMatrixSum(int[][] matrix) {
        long sum = 0;
        int count = 0;
        int minNum = Integer.MAX_VALUE;
        boolean hasZero = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int abs = Math.abs(matrix[i][j]);
                hasZero |= abs == 0;
                sum += abs;
                // 只要存在0，它可以将奇数或偶数个负数，都变为正数
                if (hasZero){
                    continue;
                }
                minNum = Math.min(abs,minNum);
                if (matrix[i][j] < 0){
                    count++;
                }
            }
        }
        if (hasZero || count % 2 == 0) {
            return sum;
        } else {
            return sum - minNum * 2L;
        }
    }
}