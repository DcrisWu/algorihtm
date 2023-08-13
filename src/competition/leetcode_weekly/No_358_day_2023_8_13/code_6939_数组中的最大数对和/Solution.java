package competition.leetcode_weekly.No_358_day_2023_8_13.code_6939_数组中的最大数对和;

/**
 * completion time = 2023.8.13
 */
class Solution {
    public int maxSum(int[] nums) {
        int n = nums.length;
        int[] max = new int[n];
        for (int i = 0; i < n; i++) {
            int temp = nums[i];
            while (temp != 0) {
                max[i] = Math.max(max[i], temp % 10);
                temp /= 10;
            }
        }
        int ans = -1;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (max[i] == max[j]) {
                    ans = Math.max(nums[i] + nums[j], ans);
                }
            }
        }
        return ans;
    }
}