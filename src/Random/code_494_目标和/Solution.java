package Random.code_494_目标和;

import java.util.Arrays;

/**
 * completion time = 2023.4.9
 */
class Solution {
    /**
     * sum = nums的和
     * 取负号部分的和 = neg
     * 取正号部分的和为 = sum - neg
     * target = (sum - neg) - neg
     * neg = (sum - target) / 2
     */
    public int findTargetSumWays(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        if (target > sum){
            return 0;
        }
        if ((sum - target) % 2 == 1) {
            return 0;
        }
        int neg = (sum - target) / 2;
        int[] dp = new int[neg + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int i = neg; i >= num; i--) {
                dp[i] += dp[i - num];
            }
        }
        return dp[neg];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 1, 1, 1, 1};
        System.out.println(solution.findTargetSumWays(nums, 3));
    }
}
