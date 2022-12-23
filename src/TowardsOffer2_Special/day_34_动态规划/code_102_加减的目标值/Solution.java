package TowardsOffer2_Special.day_34_动态规划.code_102_加减的目标值;

class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int m = nums.length;
        int n = sum * 2 + 1;
        if (target + sum >= n || target + sum < 0) {
            return 0;
        }
        int[] pre = new int[n];
        int[] now = new int[n];
        pre[sum - nums[0]] += 1;
        pre[sum + nums[0]] += 1;
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                now[j] = 0;
                if (j - nums[i] >= 0) {
                    now[j] += pre[j - nums[i]];
                }
                if (j + nums[i] < n) {
                    now[j] += pre[j + nums[i]];
                }
            }
            int[] temp = now;
            now = pre;
            pre = temp;
        }
        return pre[target + sum];
        /*int[][] dp = new int[m][n];
        dp[0][sum - nums[0]] += 1;
        dp[0][sum + nums[0]] += 1;
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j - nums[i] >= 0) {
                    dp[i][j] += dp[i - 1][j - nums[i]];
                }
                if (j + nums[i] < n) {
                    dp[i][j] += dp[i - 1][j + nums[i]];
                }
            }
        }
        if(target + sum >= n || target + sum < 0){
            return 0;
        }
        return dp[nums.length - 1][target + sum];*/
    }

    public static void main(String[] args) {
        int[] arr = {1};
        Solution solution = new Solution();
        System.out.println(solution.findTargetSumWays(arr, 2));
    }
}
