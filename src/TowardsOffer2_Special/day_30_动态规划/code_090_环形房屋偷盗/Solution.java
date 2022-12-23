package TowardsOffer2_Special.day_30_动态规划.code_090_环形房屋偷盗;

/**
 * completion time = 2022.11.9
 */
class Solution {
    public int rob(int[] nums) {
        //假设偷第一间，不偷最后一间
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (i == 1) {
                dp[i] = dp[0];
            } else if (i == nums.length - 1) {
                dp[i] = dp[i - 1];
            } else {
                dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
            }
        }
        int ans = dp[nums.length - 1];
        //假设不偷第一间，可能偷最后一间
        dp[0] = 0;
        for (
                int i = 1;
                i < nums.length; i++) {
            if (i == 1) {
                dp[i] = nums[i];
            } else {
                dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
            }
        }
        return Math.max(ans, dp[nums.length - 1]);
    }
}
