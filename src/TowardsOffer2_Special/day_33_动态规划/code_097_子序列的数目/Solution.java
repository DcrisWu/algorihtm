package TowardsOffer2_Special.day_33_动态规划.code_097_子序列的数目;

/**
 * completion time = 2022.11.13
 */
class Solution {

    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length()][t.length()];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == t.charAt(0)) {
                dp[i][0] = 1;
            }
        }
        // dp[j][i]就是当s[i]==t[j]时，dp[j][i]=sum(dp[k][i-1]),(0<=k<j),否则dp[j][i]=0
        // 也就是说当当s[i]==t[j]时，我们要求前面符合条件的情况的总和
        for (int i = 1; i < t.length(); i++) {
            int count = 0;
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == t.charAt(i)) {
                    dp[j][i] = count;
                }
                count += dp[j][i - 1];
            }
        }
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += dp[i][t.length() - 1];
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numDistinct("rabbbit", "rabbit"));
    }
}