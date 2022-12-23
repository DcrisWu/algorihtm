package TowardsOffer2_Special.day_30_动态规划.code_089_房屋被盗;

/**
 * completion time = 2022.11.9
 */
class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (i < 2) {
                dp[i] = Math.max(nums[i - 1], nums[i]);
            } else {
                dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
            }
        }
        return dp[nums.length - 1];
    }
}