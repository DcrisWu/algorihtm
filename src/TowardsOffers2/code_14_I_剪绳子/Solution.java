package TowardsOffers2.code_14_I_剪绳子;

class Solution {
    public int cuttingRope(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            for (int j = i - 1; j > 0; j--) {
                dp[i] = Math.max(dp[i], j * (i - j));
                dp[i] = Math.max(dp[i], dp[j] * (i - j));
                dp[i] = Math.max(dp[i], dp[j] * dp[i - j]);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.cuttingRope(8));
    }
}
