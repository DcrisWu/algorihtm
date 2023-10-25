package ByteDance.code_1444_切披萨的方案数;

/**
 * completion time = 2022.12.10
 */
class Solution {

    public int ways(String[] pizza, int k) {
        int m = pizza.length, n = pizza[0].length();
        int mod = (int) (1e9 + 7);
        // dp[t][i][j]表示以 (i,j)为左上角，(m-1,n-1)为右下角的披萨，分成t份的方案
        int[][][] dp = new int[k + 1][m][n];
        // pre[i][j]表示以 (i,j)为左上角，(m-1,n-1)为右下角的苹果数
        int[][] post = new int[m + 1][n + 1];
        // 初始化只有 1 份的情况
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                post[i][j] = post[i + 1][j] + post[i][j + 1] - post[i + 1][j + 1];
                post[i][j] += pizza[i].charAt(j) == 'A' ? 1 : 0;
                dp[1][i][j] = post[i][j] > 0 ? 1 : 0;
            }
        }
        // t 份由 t-1 份转移
        for (int t = 2; t <= k; t++) {
            for (int i = m - 1; i >= 0; i--) {
                for (int j = n - 1; j >= 0; j--) {
                    // 遍历行
                    for (int r = i + 1; r < m; r++) {
                        dp[t][i][j] = (dp[t][i][j] + (post[i][j] - post[r][j] > 0 ? dp[t - 1][r][j] : 0)) % mod;
                    }
                    // 遍历列
                    for (int c = j + 1; c < n; c++) {
                        dp[t][i][j] = (dp[t][i][j] + (post[i][j] - post[i][c] > 0 ? dp[t - 1][i][c] : 0)) % mod;
                    }
                }
            }
        }
        return dp[k][0][0];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] pizza = {".A..A", "A.A..", "A.AA.", "AAAA.", "A.AA."};
        System.out.println(solution.ways(pizza, 5));
    }
}
