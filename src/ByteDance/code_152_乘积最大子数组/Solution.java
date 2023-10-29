package ByteDance.code_152_乘积最大子数组;

/**
 * completion time = 2023.10.22
 */
class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0], min = nums[0], ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int mx = max, mn = min;
            max = Math.max(Math.max(mx * nums[i], mn * nums[i]), nums[i]);
            min = Math.min(Math.min(mx * nums[i], mn * nums[i]), nums[i]);
            ans = Math.max(ans, Math.max(max, min));
        }
        return ans;
    }
}