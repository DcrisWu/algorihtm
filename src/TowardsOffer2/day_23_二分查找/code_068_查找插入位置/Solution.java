package TowardsOffer2.day_23_二分查找.code_068_查找插入位置;

/**
 * completion time = 2022.11.3
 */
class Solution {
    public int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int ans = 0;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (target < nums[mid]) {
                r = mid - 1;
            } else {
                l = mid + 1;
                ans = mid;
            }
        }
        return nums[ans] >= target ? ans : ans + 1;
    }
}