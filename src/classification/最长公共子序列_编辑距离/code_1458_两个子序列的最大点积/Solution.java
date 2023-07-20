package classification.最长公共子序列_编辑距离.code_1458_两个子序列的最大点积;

/**
 * completion time = 2023.7.20
 */
class Solution {
    public int maxDotProduct(int[] s, int[] t) {
        int sLen = s.length;
        int tLen = t.length;
        // 因为是非空子序列，所以要存储一个当所有可能乘积都 <= 0时候的最大值
        // 因为所有可能的乘积都是 <= 0，所以dp出来的结果是0，返回maxNum，否则返回dp[sLen][tLen]
        int maxNum = Integer.MIN_VALUE;
        int[][] dp = new int[sLen + 1][tLen + 1];
        for (int i = 0; i < sLen; i++) {
            for (int j = 0; j < tLen; j++) {
                maxNum = Math.max(maxNum, s[i] * t[j]);
                dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                dp[i + 1][j + 1] = Math.max(dp[i + 1][j + 1], dp[i][j] + s[i] * t[j]);
            }
        }
        return dp[sLen][tLen] == 0 ? maxNum : dp[sLen][tLen];
    }

    public static void main(String[] args) {
        int[] s = {-1, -1};
        int[] t = {1, 1};
        new Solution().maxDotProduct(s, t);
    }
}
