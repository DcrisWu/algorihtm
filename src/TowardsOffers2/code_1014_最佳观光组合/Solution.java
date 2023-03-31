package TowardsOffers2.code_1014_最佳观光组合;

class Solution {
    // 最佳观光价值 = values[i] + values[j] + i - j
    // values[j] - j 固定， 求 value[i] + i的最大值就好了
    public int maxScoreSightseeingPair(int[] values) {
        int max = values[0] + 0;
        int ans = 0;
        for (int i = 1; i < values.length; i++) {
            ans = Math.max(ans, values[i] - i + max);
            max = Math.max(max, values[i] + i);
        }
        return ans;
    }
}