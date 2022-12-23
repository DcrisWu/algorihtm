package TowardsOffer2_Special.day_34_动态规划.code_101_分割等和子集;

/**
 * completion time = 2022.11.13
 */
class Solution {
    public boolean canPartition(int[] nums) {
        if (nums.length < 2) {
            return false;
        }
        int target = 0;
        int manNum = 0;
        for (int num : nums) {
            target += num;
            manNum = Math.max(manNum, num);
        }
        if (target % 2 == 1) {
            return false;
        }
        target /= 2;
        if (manNum > target) {
            return false;
        }
        // dp[i][j] = dp[i-1][j],if(j < nums[i])
        // dp[i][j] = dp[i-1][j] | dp[i-1][target-j],if(j >= nums[i])
        // 我们发现第i行的数据，仅与第i-1行有关，所以只需要用一维数据就行
        // 对于j < nums[i]，我们不变，我们只需要计算j >= nums[i]的范围的数就行了
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= nums[i]; j--) {
                dp[j] |= dp[j - nums[i]];
            }
        }
        return dp[target];
    }


}
