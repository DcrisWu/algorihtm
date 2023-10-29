package ByteDance.code_139_单词拆分;

import java.util.ArrayList;
import java.util.List;

/**
 * completion time = 2023.10.29
 */
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        // 使用动态规划
        for (int i = 1; i < dp.length; i++) {
            for (String str : wordDict) {
                if (str.length() <= i) {
                    dp[i] = dp[i - str.length()] & s.startsWith(str, i - str.length());
                    if (dp[i]) {
                        break;
                    }
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        List<String> dirct = new ArrayList<>(List.of(new String[]{"cats", "dog", "sand", "and", "cat"}));
        System.out.println(new Solution().wordBreak("catsandog", dirct));
    }
}
