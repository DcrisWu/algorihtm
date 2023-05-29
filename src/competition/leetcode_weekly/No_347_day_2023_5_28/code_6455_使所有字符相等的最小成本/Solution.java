package competition.leetcode_weekly.No_347_day_2023_5_28.code_6455_使所有字符相等的最小成本;

/**
 * completion time = 2023.5.29
 */
class Solution {
    public long minimumCost(String s) {
        int n = s.length();
        long[] left = new long[n];
        long[] right = new long[n];
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                left[i] = left[i - 1] + i;
            } else {
                left[i] = left[i - 1];
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            if (s.charAt(i) != s.charAt(i + 1)) {
                right[i] = right[i + 1] + (n - i - 1);
            } else {
                right[i] = right[i + 1];
            }
        }
        long ans = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, left[i] + right[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minimumCost("0011"));
    }
}