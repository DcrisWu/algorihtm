package TowardsOffer2_Special.day_29_回溯法.code_086_分割回文子字符串;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * completion time = 2022.11.8
 */
class Solution {

    public String[][] partition(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (boolean[] booleans : dp) {
            Arrays.fill(booleans, true);
        }
        for (int i = dp.length - 2; i >= 0; i--) {
            for (int j = i + 1; j < dp.length; j++) {
                if (i + 1 <= j - 1) {
                    dp[i][j] = dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
                } else {
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                }
            }
        }
        List<String[]> ans = new ArrayList<>();
        List<String> init = new ArrayList<>();
        backTrack(ans, s, dp, init, 0);
        return ans.toArray(new String[0][]);
    }

    void backTrack(List<String[]> ans, String s, boolean[][] dp, List<String> pre, int index) {
        if (index >= s.length()) {
            ans.add(pre.toArray(new String[0]));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            if (!dp[index][i]) {
                continue;
            }
            pre.add(s.substring(index, i + 1));
            backTrack(ans, s, dp, pre, i + 1);
            pre.remove(pre.size() - 1);
        }
    }

    public static void main(String[] args) {
        String s = "gooogle";
        Solution solution = new Solution();
        String[][] partition = solution.partition(s);
        for (String[] strings : partition) {
            for (String string : strings) {
                System.out.print(string);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
