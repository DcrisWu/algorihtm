package classification.动态规划.数位DP.code_面试题17_06_2出现的次数;

import java.util.Arrays;

/**
 * completion time = 2023.8.2
 */
class Solution {

    private int[][] memo;
    private String s;

    public int numberOf2sInRange(int n) {
        s = String.valueOf(n);
        int m = s.length();
        memo = new int[m][m];
        for (int[] ints : memo) {
            Arrays.fill(ints, -1);
        }
        return f(0, 0, true, false);
    }

    // i表示当前位，cnt表示i之前的计数结果，isLimit表示当前位是否受限,isNum表示之前是否构造了数字
    // 因为之前用过的2对后面的计算有影响，所以要记录mask
    int f(int i, int cnt, boolean isLimit, boolean isNum) {
        if (i == s.length()) {
            return cnt;
        }
        if (!isLimit && isNum && memo[i][cnt] != -1) {
            return memo[i][cnt];
        }
        int res = 0;
        // 当还没组成数字时候
        if (!isNum) {
            res = f(i + 1, cnt, false, false);
        }
        int up = isLimit ? s.charAt(i) - '0' : 9;
        // 此时遍历的都是已经组成数字的时候
        for (int d = isNum ? 0 : 1; d <= up; d++) {
            res += f(i + 1, d == 2 ? cnt + 1 : cnt, isLimit && d == up, true);
        }
        if (!isLimit && isNum) {
            memo[i][cnt] = res;
        }
        return res;
    }
}