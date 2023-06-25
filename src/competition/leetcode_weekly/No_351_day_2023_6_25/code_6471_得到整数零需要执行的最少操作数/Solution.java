package competition.leetcode_weekly.No_351_day_2023_6_25.code_6471_得到整数零需要执行的最少操作数;

/**
 * completion time = 2023.6.25
 */
class Solution {
    public int makeTheIntegerZero(int num1, int num2) {
        /**
         * x = num1 - k * num2
         * 如果 bitcount(x) > k, 此时 k 太小了，2^i最多有k的1, 但是x的1的个数比k多，所以k需要增大
         * 如果 x < k, 即使每次i都取0，也至少为k，无法满足x == k
         * 剩下的情况就符合条件，所以只需要从小增大，第一个满足的条件的就是答案
         */
        for (long k = 1; k <= num1 - num2 * k; k++) {
            if (Long.bitCount(num1 - k * num2) <= k) {
                return (int) k;
            }
        }
        return -1;
    }
}
