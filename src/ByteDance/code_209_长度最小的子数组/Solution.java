package ByteDance.code_209_长度最小的子数组;

/**
 * completion time = 2023.10.29
 */
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int ans = nums.length + 1;
        for (int i = 0, j = 0; j < nums.length; j++) {
            sum += nums[j];
            while (sum >= target) {
                ans = Math.min(j - i + 1, ans);
                sum -= nums[i];
                i++;
            }
        }
        return ans == nums.length + 1 ? 0 : ans;
    }
}
