package ByteDance.code_719;

import java.util.Arrays;

class Solution {
    // 本题 k 比较大，可以考虑使用二分法
    // 先假设一个 mid ，然后用一个函数求出数组内距离 <= mid 的组合数 num
    // 如果 num < k，说明 mid 太小了，要变大
    // 如果 num >= k，说明 mid 可能太大了，也可能就是答案
    // 我们要找的是， num >= k的情况下，mid 的最小值
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0, r = (int) 1e6;
        int ans = 0;
        while (l <= r) {
            int mid = (l + r) >> 1;
            int num = lessThanMid(nums, mid);
            if (num >= k) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }

    // 求两点间距离 <= mid 的数对的个数
    int lessThanMid(int[] nums, int mid) {
        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            int j = i + 1;
            while (j < n && nums[j] - nums[i] <= mid) {
                j++;
            }
            count += j - i - 1;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1, 3, 1};
        System.out.println(solution.smallestDistancePair(arr, 1));
    }
}
