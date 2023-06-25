package competition.leetcode_weekly.No_351_day_2023_6_25.code_6910_将数组划分成若干好子数组的方式;

import java.math.BigInteger;

/**
 * completion time = 2023.6.25
 *
 * note: 对于乘积太大需要取模的结果，可以使用 res = res * x % mod 的方式，这样可以避免溢出
 */
class Solution {
    public int numberOfGoodSubarraySplits(int[] nums) {
        long res = 0;
        int prev = -1;
        int mod = (int) (1e9 + 7);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                if (prev == -1) {
                    prev = i;
                    res = 1;
                } else {
                    res = res * (i - prev) % mod;
                    prev = i;
                }
            }
        }
        return (int) res;
    }
}
