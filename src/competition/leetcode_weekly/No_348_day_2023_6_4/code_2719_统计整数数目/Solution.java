package competition.leetcode_weekly.No_348_day_2023_6_4.code_2719_统计整数数目;

import java.util.Arrays;

/**
 * completion time = 2023.6.17
 *
 * 数位dp
 */
class Solution {
    private int minNum;
    private int maxNum;
    private int mod;

    // 数位dp
    public int count(String num1, String num2, int min_sum, int max_sum) {
        this.maxNum = max_sum;
        this.minNum = min_sum;
        this.mod = (int) (1e9 + 7);
        int ans = count(num2) - count(num1) + mod;
        int sum = 0;
        for (int i = 0; i < num1.length(); i++) {
            sum += num1.charAt(i) - '0';
        }
        if (sum >= min_sum && sum <= max_sum) {
            ans++;
        }
        return ans % mod;
    }

    int count(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        // memo[i][j] 表示 0 ~ i 位，和为 j 的不受限制的方案数，
        int[][] memo = new int[n][Math.min(n * 9, maxNum) + 1];
        for (int[] ints : memo) {
            Arrays.fill(ints, -1);
        }
        return dfs(chars, 0, 0, memo, true);
    }

    int dfs(char[] s, int idx, int sum, int[][] memo, boolean isLimit) {
        // 非法结果，返回 0
        if (sum > maxNum) {
            return 0;
        }
        if (idx == s.length) {
            // 合法结果，返回 1
            return sum >= minNum ? 1 : 0;
        }
        // 记忆化
        // 只需要记忆不受限制的情况，因为受限制的情况只有一种
        if (!isLimit && memo[idx][sum] != -1) {
            return memo[idx][sum];
        }
        int res = 0;
        int up = isLimit ? s[idx] - '0' : 9;
        for (int i = 0; i <= up; i++) {
            res = (res + dfs(s, idx + 1, sum + i, memo, isLimit && i == up)) % mod;
        }
        // 记忆化
        if (!isLimit) {
            memo[idx][sum] = res;
        }
        return res;
    }
}
