package competition.leetcode_weekly.No_353_day_2023_7_9.code_6912_构造最长非递减子数组;

import java.util.Arrays;

/**
 * completion time = 2023.7.9
 *
 * 如果当前位置仅跟上一个位置有关，那么可以使用滚动数组（可以扩展为前面有限个位置）
 * 就是使用O(1)的空间复杂度，存储影响当前位置的上一个位置的值
 */
class Solution {
    public int maxNonDecreasingLength(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        Arrays.fill(dp1, 1);
        Arrays.fill(dp2, 1);
        int ans = 1;
        for (int i = 1; i < n; i++) {
            if (nums1[i] >= nums1[i - 1]) {
                dp1[i] = dp1[i - 1] + 1;
            }
            if (nums1[i] >= nums2[i - 1]) {
                dp1[i] = Math.max(dp1[i], dp2[i - 1] + 1);
            }
            if (nums2[i] >= nums1[i - 1]) {
                dp2[i] = dp1[i - 1] + 1;
            }
            if (nums2[i] >= nums2[i - 1]) {
                dp2[i] = Math.max(dp2[i], dp2[i - 1] + 1);
            }
            ans = Math.max(ans, Math.max(dp1[i], dp2[i]));
        }
        return ans;
    }
}