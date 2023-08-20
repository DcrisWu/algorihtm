package ByteDance.code_34_在排序数组中查找元素的第一个和最后一个位置;

/**
 * completion time = 2023.8.19
 */
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int l = findMin(nums, target), r = findMax(nums, target);
        if (l > r) {
            return new int[]{-1, -1};
        }
        return new int[]{l, r};
    }

    // 寻找 < target的第一个数
    int findMin(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int ans = -1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (nums[mid] < target) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans + 1;
    }

    // 寻找 > target的第一个数
    int findMax(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int ans = nums.length;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (nums[mid] > target) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans - 1;
    }
}