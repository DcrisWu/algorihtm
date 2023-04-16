package competition.leetcode_weekly.No_340_day_2023_4_9.code_6361_对角线上的质数;

/**
 * completion time = 2023.4.9
 */
class Solution {
    public int diagonalPrime(int[][] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (isPrime(nums[i][i])) {
                ans = Math.max(ans, nums[i][i]);
            }
            if (isPrime(nums[i][nums.length - i - 1])) {
                ans = Math.max(ans, nums[i][nums.length - i - 1]);
            }
        }
        return ans;
    }

    boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        if (num <= 3) {
            return true;
        }
        int sqrt = (int) Math.sqrt(num);
        for (int i = 2; i <= sqrt; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}