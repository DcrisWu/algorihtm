package competition.leetcode_weekly.No_367_day_2023_10_15.code_100096_找出满足差值条件的下标I;

/**
 * completion time = 2023.10.15
 */
class Solution {
    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        int[] ans = new int[]{-1, -1};
        for (int i = 0; i < nums.length - indexDifference; i++) {
            for (int j = i + indexDifference; j < nums.length; j++) {
                if (Math.abs(nums[i] - nums[j]) >= valueDifference) {
                    ans[0] = i;
                    ans[1] = j;
                    return ans;
                }
            }
        }
        return ans;
    }
}