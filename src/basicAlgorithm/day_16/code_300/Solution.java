package basicAlgorithm.day_16.code_300;

import java.util.Arrays;

/**
 * completion time = 2022.9.26
 */
public class Solution {
    public int lengthOfLIS(int[] nums) {
        int ans = 1;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    if(dp[i] > ans){
                        ans = dp[i];
                    }
                }
            }
        }
        return ans;
    }
}
