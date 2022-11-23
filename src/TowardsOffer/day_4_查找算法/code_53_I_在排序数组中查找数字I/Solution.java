package TowardsOffer.day_4_查找算法.code_53_I_在排序数组中查找数字I;

/**
 * completion time = 2022.11.23
 */
class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int index = -1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (nums[mid] == target) {
                index = mid;
                break;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        if (index == -1) {
            return 0;
        }
        int left = index;
        while (left >= 0 && nums[left] == target) {
            left -= 1;
        }
        int right = index;
        while (right < nums.length && nums[right] == target) {
            right += 1;
        }
        return right - left - 1;
    }
}