package competition.leetcode_weekly.No_336_day_2023_3_12.code_6316_重排数组以得到最大前缀分数;

import java.util.Arrays;

class Solution {
    public int maxScore(int[] nums) {
        Arrays.sort(nums);
        if (nums[nums.length - 1] <= 0) {
            return 0;
        }
        int first = nums.length - 1;
        long sum = 0;
        while (first >= 0 && nums[first] > 0) {
            sum += nums[first];
            first--;
        }
        int ans = nums.length - first - 1;
        for (int i = first; i >= 0; i--) {
            if (sum + nums[i] > 0) {
                sum += nums[i];
                ans++;
            } else {
                break;
            }
        }
        return ans;
    }
}