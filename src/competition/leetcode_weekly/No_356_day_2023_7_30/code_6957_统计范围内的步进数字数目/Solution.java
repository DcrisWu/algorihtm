package competition.leetcode_weekly.No_356_day_2023_7_30.code_6957_统计范围内的步进数字数目;

import java.util.Arrays;

/**
 * completion time = 2023.7.30
 *
 * 数位dp模板题，多练练
 * memo[i][k]表示前i位，且第i位是k时候的情况总数
 */
class Solution {
    private int mod = (int) (1e9 + 7);
    private int memo[][];

    public int countSteppingNumbers(String low, String high) {
        this.memo = new int[high.length()][10];
        for (int[] ints : this.memo) {
            Arrays.fill(ints, -1);
        }
        return (cal(high) - cal(low) + (valid(low) ? 1 : 0)) % mod;
    }

    int cal(String num) {
        int m = num.length();
        this.memo = new int[m][10];
        for (int[] ints : memo) {
            Arrays.fill(ints, -1);
        }
        return f(num, 0, 0, true, false);
    }

    private boolean valid(String s) {
        for (int i = 1; i < s.length(); i++)
            if (Math.abs((int) s.charAt(i) - (int) s.charAt(i - 1)) != 1)
                return false;
        return true;
    }

    // memo[i][now]表示前i位，且最后一位是now
    int f(String num, int i, int now, boolean isLimit, boolean isNum) {
        if (i == num.length()) {
            return isNum ? 1 : 0;
        }
        // 前i位已经组成了数字，记忆化才有意义，因为受限的数字只算一次，所以没有受限的数字才可以记忆化
        if (isNum && !isLimit && memo[i][now] != -1) {
            return memo[i][now];
        }
        int res = 0;
        // 没组成数字，就直接往下递归好了
        if (!isNum) {
            res = f(num, i + 1, now, false, false);
        }
        int up = isLimit ? num.charAt(i) - '0' : 9;
        for (int d = isNum ? 0 : 1; d <= up; d++) {
            if (!isNum || Math.abs(d - now) == 1) {
                res = (res + f(num, i + 1, d, isLimit && d == up, true)) % mod;
            }
        }
        if (isNum && !isLimit) {
            memo[i][now] = res;
        }
        return res;
    }
/*
    private int mod = (int) (1e9 + 7);

    public int countSteppingNumbers(String low, String high) {
        return (calc(high) - calc(low) + mod + (valid(low) ? 1 : 0)) % mod; // +MOD 防止算出负数
    }

    private int memo[][];

    private int calc(String s) {
        int m = s.length();
        memo = new int[m][10];
        for (int i = 0; i < m; i++)
            Arrays.fill(memo[i], -1); // -1 表示没有计算过
        return f(s, 0, 0, true, false);
    }

    private boolean valid(String s) {
        for (int i = 1; i < s.length(); i++)
            if (Math.abs((int) s.charAt(i) - (int) s.charAt(i - 1)) != 1)
                return false;
        return true;
    }

    int f(String num, int i, int pre, boolean isLimit, boolean isNum) {
        if (i == num.length) {
            return isNum ? 1 : 0;
        }
        if (!isLimit && isNum && memo[i][pre] != -1) {
            return memo[i][pre];
        }
        int res = 0;
        if (!isNum) {
            res = f(num, i + 1, pre, false, false);
        }
        int up = isLimit ? num.charAt(i) - '0' : 9;
        for (int d = isNum ? 0 : 1; d <= up; d++) {
            if (!isNum || Math.abs(d - pre) == 1) {
                res = (res + f(num, i + 1, d, isLimit && d == up, true)) % mod;
            }
        }
        if (!isLimit && isNum) {
            memo[i][pre] = res;
        }
        return res;
    }*/
}