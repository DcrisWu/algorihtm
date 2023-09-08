package classification.回溯.code_131_分割回文串;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * completion time = 2023.9.8
 */
class Solution {

    private String s;
    private boolean[][] dp;
    private List<List<String>> res;

    public List<List<String>> partition(String s) {
        this.s = s;
        int n = s.length();
        dp = new boolean[n][n];
        res = new ArrayList<>();
        for (boolean[] booleans : dp) {
            Arrays.fill(booleans, true);
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
            }
        }
        recursive(new ArrayList<>(), 0);
        return res;
    }

    void recursive(List<String> pre, int idx) {
        if (idx == s.length()) {
            res.add(new ArrayList<>(pre));
        }
        for (int i = idx; i < s.length(); i++) {
            if (dp[idx][i]) {
                pre.add(s.substring(idx, i + 1));
                recursive(pre, i + 1);
                pre.remove(pre.size() - 1);
            }
        }
    }
}
