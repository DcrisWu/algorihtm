package classification.动态规划._0_1背包.code_416_分割等和子集;

/**
 * completion time = 2023.7.20
 *
 * 经典的0-1背包问题
 * 用数组存储所有可能存在的价值，从后往左遍历
 */
public class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        boolean[] dp = new boolean[sum / 2 + 1];
        dp[0] = true;
        for (int num : nums) {
            for (int j = sum / 2; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }
        return dp[sum / 2];
    }
}
