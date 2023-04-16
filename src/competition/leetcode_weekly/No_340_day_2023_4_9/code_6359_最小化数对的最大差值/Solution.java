package competition.leetcode_weekly.No_340_day_2023_4_9.code_6359_最小化数对的最大差值;

import java.util.Arrays;

/**
 * completion time = 2023.4.9
 */
class Solution {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        if (nums.length <= 3) {
            for (int i = 1; i < nums.length; i += 2) {

            }
        }
        int l = 0, r = (int) 1e9;
        int ans = 0;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (check(nums, mid, p)) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }

    boolean check(int[] nums, int cha, int p) {
        int count = 0;
        for (int i = 1; i < nums.length; ) {
            // 如果nums[i]作为一对数的最后一个，满足间隙 ≤ cha，那就 i += 2
            if (Math.abs(nums[i] - nums[i - 1]) <= cha) {
                count++;
                i += 2;
            } else {
                // 如果nums[i]作为一对数的最后一个，不满足间隙 ≤ cha，那就 i++，作为下一对数对的第一个
                i++;
            }
        }
        return count >= p;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {3, 4, 2, 3, 2, 1, 2};
        System.out.println(solution.minimizeMax(arr, 3));
    }
}
