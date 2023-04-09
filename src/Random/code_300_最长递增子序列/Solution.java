package Random.code_300_最长递增子序列;

class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int ans = 1;
        for (int i = 1; i < nums.length; i++) {
            int l = 0, r = ans - 1;
            int index = ans;
            while (l <= r) {
                int mid = (l + r) >> 1;
                if (nums[i] <= dp[mid]) {
                    index = mid;
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            dp[index] = nums[i];
            if (index == ans) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {7,7,7,7,7,7,7};
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLIS(arr));
    }
}