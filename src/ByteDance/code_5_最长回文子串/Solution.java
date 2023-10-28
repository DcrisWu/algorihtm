package ByteDance.code_5_最长回文子串;

import java.util.Arrays;
import java.util.Map;

/**
 * completion time = 2022.12.8
 */
class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        for (boolean[] d : dp) {
            Arrays.fill(d, true);
        }
        String ans = "";
        for (int i = len - 1; i >= 0; i--) {
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