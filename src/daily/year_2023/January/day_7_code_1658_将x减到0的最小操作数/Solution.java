package daily.year_2023.January.day_7_code_1658_将x减到0的最小操作数;

import java.util.Arrays;

class Solution {
    public int minOperations(int[] nums, int x) {
        int sum = Arrays.stream(nums).sum();
        if (sum < x) {
            return -1;
        }
        int lsum = 0, rsum = sum;
        int right = 0;
        int ans = nums.length + 1;
        // 0到i为 left，i+1到n-1为 right
        for (int i = -1; i < nums.length; i++) {
            if (i != -1) {
                lsum += nums[i];
            }
            while (right < nums.length && lsum + rsum > x) {
                rsum -= nums[right];
                right++;
            }
            if (lsum + rsum == x) {
                ans = Math.min(ans, (i + 1) + (nums.length) - right);
            }
        }
        return ans > nums.length ? -1 : ans;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 20, 1, 1, 3};
        Solution solution = new Solution();
        System.out.println(solution.minOperations(arr, 10));
    }
}
