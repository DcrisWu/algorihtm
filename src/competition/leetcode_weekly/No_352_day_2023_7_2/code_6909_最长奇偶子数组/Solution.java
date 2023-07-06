package competition.leetcode_weekly.No_352_day_2023_7_2.code_6909_最长奇偶子数组;

/**
 * completion time = 2023.7.2
 */
class Solution {
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int prev = -1;
        int ans = 0;
        int idx = 0;
        while (idx < nums.length) {
            if (prev == -1) {
                if (nums[idx] <= threshold && nums[idx] % 2 == 0) {
                    prev = idx;
                    ans = Math.max(ans, 1);
                }
                idx++;
            } else {
                if (nums[idx] <= threshold && nums[idx] % 2 != nums[idx - 1] % 2) {
                    ans = Math.max(ans, idx - prev + 1);
                    idx++;
                } else {
                    prev = -1;
                }
            }

        }
        return ans;
    }
}