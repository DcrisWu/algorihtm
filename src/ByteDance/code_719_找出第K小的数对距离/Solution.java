package ByteDance.code_719_找出第K小的数对距离;

import java.util.Arrays;

/**
 * completion time = 2023.10.24
 */
class Solution {
    // 本题 k 比较大，可以考虑使用二分法
    // 先假设一个 mid ，然后用一个函数求出数组内距离 <= mid 的组合数 num
    // 如果 num < k，说明 mid 太小了，要变大
    // 如果 num >= k，说明 mid 可能太大了，也可能就是答案
    // 我们要找的是， num >= k的情况下，mid 的最小值
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int l = 0, r = (int) 1e6;
        int ans = 0;
        while (l <= r) {
            int mid = (l + r) >> 1;
            // 寻找一个距离 mid ，使得数对距离 <= mid 的数为 k，让这个 mid 最小
            if (lessThanTarget(nums, mid) >= k) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }

    // 求两点间距离 <= target 的数对的个数
    int lessThanTarget(int[] nums, int target) {
        int cnt = 0;
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            // 寻找最大的j ，使得nums[j] - nums[i] <= target
            // 表示以 nums[i]为左端点的数对，差 <= target
            int l = i + 1, r = n - 1;
            int j = i;
            while (l <= r) {
                int mid = (l + r) >> 1;
                if (nums[mid] - nums[i] <= target) {
                    j = mid;
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            cnt += (j - i);
        }
        return cnt;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1, 6, 1};
        System.out.println(solution.smallestDistancePair(arr, 3));
    }
}
