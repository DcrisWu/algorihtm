package ByteDance.code_718_最长重复子数组;

/**
 * completion time = 2023.10.29
 */
class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int ans = 0;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            if (nums1[i] == nums2[0]) {
                dp[i][0] = 1;
                ans = 1;
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums1[0] == nums2[i]) {
                dp[0][i] = 1;
                ans = 1;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (nums1[i] == nums2[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    ans = Math.max(dp[i][j], ans);
                }
            }
        }
        return ans;
    }
}