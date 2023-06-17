package competition.leetcode_weekly.No_348_day_2023_6_4.code_2717_半有序排列;

/**
 * completion time = 2023.6.8
 */
class Solution {
    public int semiOrderedPermutation(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                res = i;
                break;
            }
        }
        System.arraycopy(nums, 0, nums, 1, res);
        nums[0] = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == nums.length) {
                res += nums.length - i - 1;
                break;
            }
        }
        return res;
    }
}
