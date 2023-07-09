package competition.leetcode_weekly.No_353_day_2023_7_9.code_6919_使数组中的所有元素都等于零;

/**
 * completion time = 2023.7.9
 */
class Solution {
    public boolean checkArray(int[] nums, int k) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            /// 减的太多了，就不符合条件
            if (nums[i] < 0) {
                return false;
            }
            // 已经是0了，就符合条件跳过
            if (nums[i] == 0) {
                continue;
            }
            // 无法构造一个长为K的子数组
            if (i > n - k) {
                return false;
            }
            // nums[i] > 0，说明还没有减到0，需要继续减
            // 从i开始构造一个长为k的子数组，从i到i+k-1，每个数都减去nums[i]
            for (int j = i; j <= i + k - 1; j++) {
                nums[j] -= nums[i];
            }
        }
        return true;
    }
}