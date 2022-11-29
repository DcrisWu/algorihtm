package TowardsOffer.day_9_动态规划_中等.code_42_连续子数组的最大和;

/**
 * completion time = 2022.11.29
 */
class Solution {
    public int maxSubArray(int[] nums) {
        int temp = nums[0];
        int ans = temp;
        for (int i = 1; i < nums.length; i++) {
            temp = Math.max(nums[i], temp + nums[i]);
            ans = Math.max(temp, ans);
        }
        return ans;
    }
}
