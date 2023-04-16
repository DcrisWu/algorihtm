package competition.leetcode_weekly.No_320_day_2022_11_20.code_6241_数组中不等三元组的数目;

/**
 * completion time = 2022.11.20
 */
class Solution {
    public int unequalTriplets(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] != nums[j] && nums[j] != nums[k] && nums[i] != nums[k]) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
