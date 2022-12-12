package ByteDance.code_1444_切披萨的方案数;

/**
 * completion time = 2022.12.10
 */
class Solution {

    public int ways(String[] pizza, int k) {
        int m = pizza.length;
        int n = pizza[0].length();
        int mod = (int) (1e9 + 7);
        //dp[t][i][j]表示在以(i,j)为左上角,(m−1,n−1)为右下角的pizza矩阵中切t刀的可能方案数，则需返回dp[k−1][0][0]
        int[][] postSum = new int[m + 1][n + 1];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                postSum[i][j] = postSum[i + 1][j] + postSum[i][j + 1] - postSum[i + 1][j + 1];
                postSum[i][j] += pizza[i].charAt(j) == 'A' ? 1 : 0;
            }
        }
        long[][][] dp = new long[k][m][n];
        //初始化k == 0 时候的数据
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[0][i][j] = postSum[i][j] > 0 ? 1L : 0L;
            }
        }
        // 切 t 刀的情况是由 切 t-1 刀的情况地推过来的
        for (int t = 1; t < k; t++) {
            // 遍历 m 行 n 列
            for (int i = m - 1; i >= 0; i--) {
                for (int j = n - 1; j >= 0; j--) {
                    // 遍历每一行
                    // 利用局部最优，右下角是局部最优的
                    for (int h = i + 1; h < m; h++) {
                        // 如果以第 h 行为下半部分pizza的苹果数量 < (i,j)到（m-1,n-1）的部分的pizza数量，就加上下半部分划分的方案数量，否则加上0
                        dp[t][i][j] += postSum[i][j] - postSum[h][j] > 0L ? dp[t - 1][h][j] : 0L;
                    }
                    // 遍历每一列
                    for (int h = j + 1; h < n; h++) {
                        // 与遍历行同理
                        dp[t][i][j] += postSum[i][j] - postSum[i][h] > 0L ? dp[t - 1][i][h] : 0L;
                    }
                }
            }
        }
        return (int) (dp[k - 1][0][0]%mod);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] pizza = {"A..","AAA","..."};
        System.out.println(solution.ways(pizza, 3));
    }
}
