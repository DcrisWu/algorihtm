package classification.最长公共子序列_编辑距离.code_72_编辑距离;

/**
 * completion time = 2023.7.20
 * 删除一个字符
 * 插入一个字符，相当于在另一个字符串中删除一个字符
 * 替换一个字符
 * 所以实际上只有两种操作
 */
public class Solution {
    public int minDistance(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        int[][] dp = new int[sLen + 1][tLen + 1];
        // 初始化
        for (int i = 0; i <= sLen; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= tLen; j++) {
            dp[0][j] = j;
        }
        for (int i = 0; i < sLen; i++) {
            for (int j = 0; j < tLen; j++) {
                // 字符相等时候不需要操作
                if (s.charAt(i) == t.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j];
                } else {
                    // 删除一个字符时，讨论删除s[i]还是t[j]
                    dp[i + 1][j + 1] = Math.min(dp[i][j + 1], dp[i + 1][j]) + 1;
                    // 修改一个字符后，s[i] == t[j]，那么dp[i][j] = dp[i-1][j-1] + 1，跟上一个操作后的值取最小值
                    dp[i + 1][j + 1] = Math.min(dp[i + 1][j + 1], dp[i][j] + 1);
                }
            }
        }
        return dp[sLen][tLen];
    }
}
