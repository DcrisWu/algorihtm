package algorithm.day_2.code_153;

/**
 * completion time = 2022.9.15
 */
class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1, ans = nums[r];
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (nums[mid] <= ans) {
                ans = nums[mid];
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }
}
