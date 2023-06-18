package competition.leetcode_weekly.No_350_day_2023_6_18.code_6890_找出分区值;

import java.util.Arrays;

class Solution {
    public int findValueOfPartition(int[] nums) {
        Arrays.sort(nums);
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {
            int pre = nums[i - 1];
            int now = nums[i];
            ans = Math.min(ans, Math.abs(now - pre));
        }
        return ans;
    }
}