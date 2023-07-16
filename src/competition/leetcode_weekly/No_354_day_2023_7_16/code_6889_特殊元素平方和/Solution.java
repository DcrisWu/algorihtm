package competition.leetcode_weekly.No_354_day_2023_7_16.code_6889_特殊元素平方和;

/**
 * completion time = 2023.7.16
 */
class Solution {
    public int sumOfSquares(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (n % (i+1) == 0){
                ans += nums[i] * nums[i];
            }
        }
        return ans;
    }
}