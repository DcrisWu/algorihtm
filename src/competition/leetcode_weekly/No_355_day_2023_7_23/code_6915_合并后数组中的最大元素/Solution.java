package competition.leetcode_weekly.No_355_day_2023_7_23.code_6915_合并后数组中的最大元素;

/**
 * completion time = 2023.7.23
 */
class Solution {
    public long maxArrayValue(int[] nums) {
        long prev = nums[nums.length - 1];
        long max = prev;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (prev >= nums[i]) {
                prev += nums[i];
            }else {
                prev = nums[i];
            }
            max = Math.max(max, prev);
        }
        return max;
    }
}
