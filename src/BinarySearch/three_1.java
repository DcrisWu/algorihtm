package BinarySearch;

import java.util.Arrays;

/**
 * code_300
 */
public class three_1 {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, 1);
        int max = 1;
        for (int i = 1; i >= 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    ans[i] = Math.max(ans[i], ans[j] + 1);
                    max = Math.max(max, ans[i]);
                }
            }
        }
        return max;
    }
}
