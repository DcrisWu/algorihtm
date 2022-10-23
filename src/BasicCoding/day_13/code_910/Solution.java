package BasicCoding.day_13.code_910;

import java.util.Arrays;

/**
 * completion time = 2022.10.8
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1, 3, 6};
        System.out.println(solution.smallestRangeII(arr, 3));
    }

    public int smallestRangeII(int[] nums, int k) {
        Arrays.sort(nums);
        int len = nums.length;
        int dis = nums[len - 1] - nums[0];
        for (int i = 0; i < len - 1; i++) {
            int max = Math.max(nums[i] + k, nums[len - 1] - k);
            int min = Math.min(nums[0] + k, nums[i + 1] - k);
            dis = Math.min(max - min, dis);
        }
        return dis;
    }
}
