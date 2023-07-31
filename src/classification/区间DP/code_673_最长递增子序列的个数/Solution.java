package classification.区间DP.code_673_最长递增子序列的个数;

/**
 * completion time = 2023.7.21
 *
 * 最长递增子序列可以用回溯/dp/二分+贪心，回溯/dp是最简单的，当使用二分+贪心做不出来时，就考虑简单的做法
 */
class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int maxLen = 0, ans = 0;
        // dp[i]表示以nums[i]结尾的最大长度
        int[] dp = new int[n];
        // count[i]表示以nums[i]结尾的最大长度的个数
        int[] count = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            count[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        // 在原有基础上长度 + 1,count[i]就直接继承于count[j]
                        count[i] = count[j];
                    } else if (dp[j] + 1 == dp[i]) {
                        // 构建的新的子序列长度和原来的一样，那就count[i] += count[j]
                        count[i] += count[j];
                    }
                }
            }
            if (dp[i] > maxLen) {
                maxLen = dp[i];
                // 重置
                ans = count[i];
            } else if (dp[i] == maxLen) {
                ans += count[i];
            }
        }
        return ans;
    }
}
