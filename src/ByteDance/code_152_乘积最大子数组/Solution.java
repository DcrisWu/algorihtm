package ByteDance.code_152_乘积最大子数组;

/**
 * completion time = 2023.10.22
 */
class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0], min = nums[0], ans = nums[0];
        // 计算的时候不用刻意去考虑当前子数组的最小值是否 < 0，最小值就算 >= 0也不影响取最大值
        for (int i = 1; i < nums.length; i++) {
            int mx = max, mn = min;
            // 只是因为当num[i] < 0同时 mn < 0的情况下，可能出现反转，所以才维护一个最大值一个最小值
            max = Math.max(Math.max(mx * nums[i], mn * nums[i]), nums[i]);
            min = Math.min(Math.min(mx * nums[i], mn * nums[i]), nums[i]);
            ans = Math.max(max, ans);
        }
        return ans;
    }
}