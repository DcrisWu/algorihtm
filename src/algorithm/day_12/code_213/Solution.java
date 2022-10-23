package algorithm.day_12.code_213;

/**
 * completion time = 2022.9.24
 */
class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int n = nums.length;
        int now1 = nums[0];
        //拿nums[0]，不拿nums[1]
        int first = nums[0], second = first;
        for (int i = 2; i < n - 1; i++) {
            now1 = Math.max(second, first + nums[i]);
            first = second;
            second = now1;
        }
        int now2 = nums[1];
        //拿nums[1]，不拿nums[0]
        first = 0;
        second = nums[1];
        for (int i = 2; i < n; i++) {
            now2 = Math.max(second, first + nums[i]);
            first = second;
            second = now2;
        }
        return Math.max(now1, now2);
    }
}
