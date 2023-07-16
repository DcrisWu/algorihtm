package competition.leetcode_weekly.No_354_day_2023_7_16.code_6929_数组的最大美丽值;

import java.util.Arrays;

/**
 * completion time = 2023.7.16
 */
class Solution {
    public int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0;
        int ans = 0;
        for (int r = 0; r < nums.length; r++) {
            while (nums[r] - nums[l] > k * 2) {
                l++;
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
}
