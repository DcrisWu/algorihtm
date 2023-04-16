package competition.leetcode_weekly.No_341_day_2023_4_16.code_6350_找出可整除性得分最大的整数;

/**
 * completion time = 2023.4.16
 */
class Solution {
    public int maxDivScore(int[] nums, int[] divisors) {
        int ans = divisors[0];
        int get = 0;
        for (int divisor : divisors) {
            int count = 0;
            for (int num : nums) {
                if (num % divisor == 0) {
                    count++;
                }
            }
            if (count == get) {
                ans = Math.min(ans, divisor);
            } else if (count > get) {
                ans = divisor;
                get = count;
            }
        }
        return ans;
    }
}
