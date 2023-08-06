package classification.动态规划.数位DP.code_233_数字1的个数;

import java.util.Arrays;

/**
 * completion time = 2023.8.2
 */
class Solution {

    private int[][] memo;
    private String s;

    // f(i,cnt,isLimit,isNum)表示前i位，有cnt个1的情况数，本题是否是数字不重要
    public int countDigitOne(int n) {
        this.s = String.valueOf(n);
        int m = s.length();
        this.memo = new int[m][m];
        for (int[] ints : memo) {
            Arrays.fill(ints, -1);
        }
        return f(0, 0, true, false);
    }

    // 因为之前用过的2对后面的计算有影响，所以要记录mask
    int f(int i, int cnt, boolean isLimit, boolean isNum) {
        // 前面已经出现过的1的次数，就是当前情况下的1的个数
        if (i == memo.length) {
            return cnt;
        }
        if (!isLimit && isNum && memo[i][cnt] != -1) {
            return memo[i][cnt];
        }
        int res = 0;
        if (!isNum) {
            res = f(i + 1, cnt, false, false);
        }
        int up = isLimit ? s.charAt(i) - '0' : 9;
        for (int d = isNum ? 0 : 1; d <= up; d++) {
            res += f(i + 1, d == 1 ? cnt + 1 : cnt, isLimit && d == up, true);
        }
        if (!isLimit && isNum) {
            memo[i][cnt] = res;
        }
        return res;
    }

}
