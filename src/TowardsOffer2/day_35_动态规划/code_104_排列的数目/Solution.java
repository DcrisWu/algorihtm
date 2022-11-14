package TowardsOffer2.day_35_动态规划.code_104_排列的数目;

/**
 * completion time = 2022.11.14
 */
class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
//        Arrays.sort(nums);
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == i) {
                    dp[i] += 1;
                }
                if(i - nums[j] >= 0){
                    dp[i] += dp[i - nums[j]];
                }
            }
        }
        return dp[target];
    }
}