package classification.最长回文子序列.code_375_猜数字大小II;

/**
 * completion time = 2023.7.30
 *
 * 这道题的递归边界不是很理解
 */
class Solution {
    // 这道题其实就是找到一个能花最少钱，但是试最差结果的
    // f(i, j) = min(f(i, k-1) + f(k+1, j) + k),for k in [i+1,j)
    // j正序，i倒序
    public int getMoneyAmount(int n) {
        int[][] f = new int[n + 1][n + 1];
        for (int i = n - 1; i >= 1; i--) {
            for (int j = i + 1; j <= n; j++) {
                f[i][j] = j + f[i][j - 1];
                for (int k = i; k < j; k++) {
                    f[i][j] = Math.min(f[i][j], k + Math.max(f[i][k - 1], f[k + 1][j]));
                }
            }
        }
        return f[1][n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().getMoneyAmount(10));
    }
}