package competition.leetcode_weekly.No_341_day_2023_4_16.code_6376_一最多的行;

/**
 * completion time = 2023.4.16
 */
class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int[] ans = new int[2];
        for (int i = 0; i < mat.length; i++) {
            int count = 0;
            for (int j : mat[i]) {
                count += j == 1 ? 1 : 0;
            }
            if (count > ans[1]){
                ans[0] = i;
                ans[1] = count;
            }
        }
        return ans;
    }
}
