package ByteDance.code_5_最长回文子串;

import java.util.Arrays;

/**
 * completion time = 2022.12.8
 */
class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        for (boolean[] booleans : dp) {
            Arrays.fill(booleans, true);
        }
        String ans = s.substring(0,1);
        for (int i = len - 2; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                dp[i][j] = dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
                if (dp[i][j] && j - i + 1 > ans.length()) {
                    ans = s.substring(i, j + 1);
                }
            }
        }
        return ans;
    }
}