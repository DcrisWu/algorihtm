package TowardsOffer.day_13_双指针_简单.code_57_和为s的两个数字;

/**
 * completion time = 2022.12.3
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            if (nums[l] + nums[r] == target) {
                return new int[]{nums[l], nums[r]};
            } else if (nums[l] + nums[r] > target) {
                r--;
            } else {
                l++;
            }
        }
        return new int[2];
    }
}