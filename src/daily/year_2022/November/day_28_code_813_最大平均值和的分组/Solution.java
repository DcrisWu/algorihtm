package daily.year_2022.November.day_28_code_813_最大平均值和的分组;

class Solution {
    public double largestSumOfAverages(int[] nums, int k) {
        int[] preSum = new int[nums.length + 1];
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
        // dp表示i次分组，以index j为最后一个下标时，最大的运算结果
        double[][] dp = new double[k][nums.length];
        for (int i = 0; i <= nums.length - k; i++) {
            dp[0][i] = (preSum[i + 1] - preSum[0]) / ((i + 1) * 1.0);
        }
        // 前 i 次分组，以index = j为最后一个下标的 ans =
        // 前 i-1 次分组中，max{ 以index = m为最后一个下标的 ans + (j+1 -> i)的 sum 的avg }
        // i >= 0 && i < k
        // j >= i && j <= nums.length - k + i, 因为要保证 j 及之前至少有 i，j 后面还可以分
        // m就是遍历，m至少要有 i-1个，m 到 j 要有空隙
        for (int i = 1; i < k; i++) {
            for (int j = i; j <= nums.length - k + i; j++) {
                for (int m = i - 1; m < j; m++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][m] + ((preSum[j + 1] - preSum[m + 1]) / ((j - m) * 1.0)));
                }
            }
        }
        return dp[k - 1][nums.length - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(solution.largestSumOfAverages(arr, 4));
    }
}