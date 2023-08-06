package classification.动态规划.数位DP.code_600_不含连续1的非负整数;

import java.util.Arrays;

/**
 * completion time = 2023.8.2
 */
class Solution {
    private String s;
    private int[][] memo;

    // 对二进制进行数位dp
    public int findIntegers(int n) {
        s = Integer.toBinaryString(n);
        // memo[i]表示前i位，最后一位是0或者1
        memo = new int[s.length()][2];
        for (int[] ints : memo) {
            Arrays.fill(ints, -1);
        }
        return f(0, 0, true, false);
    }

    // 因为已经使用过的数字的最后一位对结果有影响，所以需要加mask
    int f(int i, int bit, boolean isLimit, boolean isNum) {
        if (i == s.length()) {
            return 1;
        }
        if (!isLimit && isNum && memo[i][bit] != -1) {
            return memo[i][bit];
        }
        int res = 0;
        if (!isNum) {
            res = f(i + 1, bit, false, false);
        }
        int up = isLimit ? s.charAt(i) - '0' : 1;
        for (int d = isNum ? 0 : 1; d <= up; d++) {
            if (bit != 1 || d != 1) {
                res += f(i + 1, d, isLimit && d == up, true);
            }
        }
        if (!isLimit && isNum) {
            memo[i][bit] = res;
        }
        return res;
    }

}
