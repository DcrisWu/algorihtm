package ByteDance.code_135_分发糖果;

import java.util.Arrays;

class Solution {
    public int candy(int[] ratings) {
        int[] ans = new int[ratings.length];
        Arrays.fill(ans, 1);
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                if (ans[i] <= ans[i - 1]) {
                    ans[i] = ans[i - 1] + 1;
                }
            }
        }
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                if (ans[i] <= ans[i + 1]) {
                    ans[i] = ans[i + 1] + 1;
                }
            }
        }
        int sum = 0;
        for (int an : ans) {
            sum += an;
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1, 2, 2};
        System.out.println(solution.candy(arr));
    }
}