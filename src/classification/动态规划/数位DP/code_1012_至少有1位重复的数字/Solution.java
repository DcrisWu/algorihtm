package classification.动态规划.数位DP.code_1012_至少有1位重复的数字;

import java.util.Arrays;

/**
 * completion time = 2023.8.2
 */
class Solution {
    private int[][] memo;
    private String s;

    // 本题求的是至少有一个数字重复的数字的个数，可以转换思路，求出所有数字都不重复的数的个数，再用n-res就是答案
    public int numDupDigitsAtMostN(int n) {
        s = String.valueOf(n);
        memo = new int[s.length()][1 << 10];
        for (int[] ints : memo) {
            Arrays.fill(ints, -1);
        }
        return n - f(0, 0, true, false);
    }

    int f(int i, int mask, boolean isLimit, boolean isNum) {
        if (i == s.length()) {
            return isNum ? 1 : 0;
        }
        if (!isLimit && isNum && memo[i][mask] != -1) {
            return memo[i][mask];
        }
        int res = 0;
        if (!isNum) {
            res = f(i + 1, mask, false, false);
        }
        int up = isLimit ? s.charAt(i) - '0' : 9;
        for (int d = isNum ? 0 : 1; d <= up; d++) {
            // 如果没有出现过，才递归
            if ((mask >> d & 1) == 0) {
                res += f(i + 1, mask | (1 << d), isLimit && d == up, true);
            }
        }
        if (!isLimit && isNum) {
            memo[i][mask] = res;
        }
        return res;
    }


}
