package classification.动态规划.数位DP.code_902_最大为N的数字组合;

import java.util.Arrays;

/**
 * completion time = 2023.8.2
 */
class Solution {
    private String s;
    private String[] digits;
    private int[] memo;

    public int atMostNGivenDigitSet(String[] digits, int n) {
        this.digits = digits;
        s = String.valueOf(n);
        memo = new int[s.length()];
        Arrays.fill(memo, -1);
        return f(0, true, false);
    }

    // 这题不对使用过的数字次数限制，所以不需要用mask，只有已经使用过的数对结果产生影响，才需要用mask
    int f(int i, boolean isLimit, boolean isNum) {
        if (i == s.length()) {
            return isNum ? 1 : 0;
        }
        if (!isLimit && isNum && memo[i] != -1) {
            return memo[i];
        }
        int res = 0;
        if (!isNum) {
            res = f(i + 1, false, false);
        }
        int up = isLimit ? s.charAt(i) - '0' : 9;
        for (String digit : digits) {
            int num = Integer.parseInt(digit);
            if (num > up) {
                break;
            }
            res += f(i + 1, isLimit && num == up, true);
        }
        if (!isLimit && isNum) {
            memo[i] = res;
        }
        return res;
    }
}
