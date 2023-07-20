package classification.动态规划._0_1背包.code_494_目标和;

import java.util.Arrays;

/**
 * completion time = 2023.7.20
 *
 *  背包问题，就是把价值的所有可能情况全部列出来，用数组表示
 *  本题中，价值就是所有可能的和，因为数组中的数都是正数，所以和的范围是[0, sum]
 *  因为dp[i][j] = dp[i-1][j] + dp[i-1][j-nums[i]]，数据只与前一行的数据有关，所以可以优化为一维数组
 *  因为dp[j] = dp[j] + dp[j-nums[i]]，当前数据与前面的数据有关，所以需要从后往前遍历，避免覆盖
 *  ！！！！ 0-1背包问题需要从后往前遍历，避免覆盖 ！！！！！
 */
public class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum - target) % 2 != 0){
            return 0;
        }
        int neg = (sum - target) / 2;
        if (neg < 0){
            return 0;
        }
        // dp[i][j]表示前i个数中选取若干个数，使得其和为j的方案数
        // dp[i][j] = dp[i-1][j] + dp[i-1][j-nums[i]]
        // 因为dp[i][j]只与dp[i-1][j]和dp[i-1][j-nums[i]]有关，所以可以使用一维数组
        int[] dp = new int[neg + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = neg; j >= nums[i]; j--) {
                dp[j] = dp[j] + dp[j - nums[i]];
            }
        }
        return dp[neg];
    }

    public static void main(String[] args) {
        int[] arr = {1,1,1,1,1};
        int targetSumWays = new Solution().findTargetSumWays(arr, 3);
        System.out.println(targetSumWays);
    }
}
