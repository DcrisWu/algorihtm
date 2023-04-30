package competition.leetcode_weekly.No_342_day_2023_4_23.code_6391_倍数求和;

/**
 * completion time = 2023.4.23
 */
class Solution {
    public int sumOfMultiples(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (judge(i)) {
                sum += i;
            }
        }
        return sum;
    }

    public boolean judge(int num) {
        return num % 3 == 0 || num % 5 == 0 || num % 7 == 0;
    }
}