package competition.leetcode_weekly.No_337_day_2023_3_19.code_6321_执行操作后的最大MEX;

import java.util.Arrays;

/**
 * completion time = 2023.3.19
 */
class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] % value;
            if (nums[i] < 0) {
                nums[i] += value;
            }
        }
        Arrays.sort(nums);
        int j = 0;
        while (j < nums.length) {
            int pre = nums[j];
            for (int k = j + 1; k < nums.length; k++) {
                if (nums[k] == pre) {
                    nums[k] += value * (k - j);
                }else {
                    j = k;
                    break;
                }
            }
            if (j == nums.length-1){
                break;
            }
        }
        Arrays.sort(nums);
        for (int num : nums) {
            while (num == ans) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {3, 0, 3, 2, 4, 2, 1, 1, 0, 4};
        System.out.println(solution.findSmallestInteger(arr, 5));
    }
}
