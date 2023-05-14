package competition.leetcode_weekly.No_345_day_2023_5_14.code_6431_相邻值的按位异或;

/**
 * completion time = 2023.5.14
 */
class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int n = derived.length;
        int[] original = new int[n];
        boolean judge = false;
        for (int i = 0; i < n; i++) {
            if (i == n - 1) {
                int temp = original[i] ^ original[0];
                judge = temp == derived[i];
            } else {
                original[i + 1] = derived[i] ^ original[i];
            }
        }
        return judge;
    }
}