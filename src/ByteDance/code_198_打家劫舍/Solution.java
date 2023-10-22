package ByteDance.code_198_打家劫舍;

class Solution {
    public int rob(int[] nums) {
        // 大家劫舍，偷第一个和不偷第一个两种情况开始遍历
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        if (len == 2) {
            return Math.max(nums[0], nums[1]);
        }
        // 偷第一个
        int first = nums[0], second = first;
        for (int i = 2; i < len; i++) {
            int now = Math.max(first + nums[i], second);
            first = second;
            second = now;
        }
        int ans = second;
        // 不偷第一个
        first = 0;
        second = nums[1];
        for (int i = 2; i < len; i++) {
            int now = Math.max(first + nums[i], second);
            first = second;
            second = now;
        }
        return Math.max(ans, second);
    }
}