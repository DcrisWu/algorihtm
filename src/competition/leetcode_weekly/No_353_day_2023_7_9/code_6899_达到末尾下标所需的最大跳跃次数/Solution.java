package competition.leetcode_weekly.No_353_day_2023_7_9.code_6899_达到末尾下标所需的最大跳跃次数;

import java.util.Arrays;

/**
 * completion time = 2023.7.9
 */
class Solution {
    public int maximumJumps(int[] nums, int target) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (dp[i]== -1){
                    continue;
                }
                if (Math.abs(nums[i] - nums[j]) <= target) {
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                }
            }
        }
        return dp[n - 1];
    }
}
