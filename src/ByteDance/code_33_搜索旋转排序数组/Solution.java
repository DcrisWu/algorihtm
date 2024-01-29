package ByteDance.code_33_搜索旋转排序数组;

class Solution {
    public int search(int[] nums, int target) {
        // 假设旋转前数组的最后元素在旋转后的数组的下标 i 处
        // 那么nums[0]到nums[i]是递增的，nums[i+1]到nums[nums.length-1]之间也是递增的
        // nums[index] >= nums[0], 0 <= index <=i
        // nums[index] <= nums[0], i+1 <= index < nums.length
        int l = 0, r = nums.length - 1;
        int ans = -1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (nums[mid] == target) {
                ans = mid;
                break;
            }
            // 在左边
            if (target >= nums[0]) {
                if (nums[mid] < nums[0]) {
                    r = mid - 1;
                } else {
                    if (nums[mid] < target) {
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
            } else {
                // 在右边
                if (nums[mid] >= nums[0]) {
                    l = mid + 1;
                } else {
                    if (nums[mid] < target) {
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
            }
        }
        return ans;
    }
}