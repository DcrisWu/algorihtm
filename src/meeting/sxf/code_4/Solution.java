package meeting.sxf.code_4;

import java.util.*;


public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().min_cut_string("abaccbc"));
    }

    public int min_cut_string(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = i;
        }
        boolean[][] reverse = new boolean[n][n];
        for (boolean[] booleans : reverse) {
            Arrays.fill(booleans, true);
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                reverse[i][j] = s.charAt(i) == s.charAt(j) && reverse[i + 1][j - 1];
            }
        }
        for (int i = 0; i < n; i++) {
            dp[i + 1] = Math.min(dp[i + 1], dp[i] + 1);
            for (int j = i - 1; j >= 0; j--) {
                if (reverse[j][i]) {
                    dp[i + 1] = Math.min(dp[j] + 1, dp[i + 1]);
                }
            }
        }
        return dp[n] - 1;
    }
}
