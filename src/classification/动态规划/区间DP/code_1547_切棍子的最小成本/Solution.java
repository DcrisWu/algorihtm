package classification.动态规划.区间DP.code_1547_切棍子的最小成本;

import java.util.Arrays;

/**
 * completion time = 2023.7.31
 */
class Solution {

    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        int[] arr = new int[cuts.length + 2];
        arr[0] = 0;
        System.arraycopy(cuts, 0, arr, 1, cuts.length);
        arr[arr.length - 1] = n;
        int[][] dp = new int[arr.length][arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = 1; k < arr.length - 1; k++) {
                    if (k > i && k < j) {
                        if (dp[i][j] == 0) {
                            dp[i][j] = dp[i][k] + dp[k][j] + arr[j] - arr[i];
                        } else {
                            dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j] + arr[j] - arr[i]);
                        }
                    }
                }
            }
        }
        return dp[0][arr.length - 1];

    }

    public static void main(String[] args) {
        int[] cuts = {1, 3, 4, 5};
        System.out.println(new Solution().minCost(7, cuts));
    }
}
