package basicAlgorithm.day_5.code_209;

/**
 * completion time = 2022.9.17
 */
public class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int i = 0, sum = 0, ans = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            sum += nums[j];
            //如果满足条件，就尝试左端点右移一位，i+1；否则就看下一个j
            while (i <= j && sum >= target) {
                ans = Math.min(ans, j - i + 1);
                sum -= nums[i];
                i++;
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
