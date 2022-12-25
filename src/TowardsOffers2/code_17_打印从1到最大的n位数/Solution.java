package TowardsOffers2.code_17_打印从1到最大的n位数;

class Solution {
    public int[] printNumbers(int n) {
        int max = (int) Math.pow(10, n) - 1;
        int[] dp = new int[max];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = i + 1;
        }
        return dp;
    }
}