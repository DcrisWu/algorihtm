package competition.leetcode_weekly.No_351_day_2023_6_25.code_2748_美丽下标对的数目;

class Solution {
    public int countBeautifulPairs(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int a = String.valueOf(nums[i]).toCharArray()[0] - '0';
                int b = nums[j] % 10;
                if (gcd(a, b) == 1) {
                    res++;
                }
            }
        }
        return res;
    }

    int gcd(int x, int y) {
        if (x % y == 0) {
            return y;
        }
        return gcd(y, x % y);
    }
}
