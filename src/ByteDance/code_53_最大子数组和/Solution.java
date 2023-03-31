package ByteDance.code_53_最大子数组和;

class Solution {
    public int maxSubArray(int[] nums) {
        int preSum = 0;
        int min = 0;
        int ans = Integer.MIN_VALUE;
        for (int num : nums) {
            preSum += num;
            ans = Math.max(ans, preSum - min);
            min = Math.min(min, preSum);
        }
        return ans;
    }
}