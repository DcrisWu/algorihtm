package competition.leetcode_weekly.No_642_day_2023_4_23.code_6392_使数组所有元素变成1的最少操作次数;

/**
 * completion time = 2023.4.24
 */
class Solution {
    public int minOperations(int[] nums) {
        int cnt = nums[0] == 1 ? 1 : 0, gcdAll = nums[0], n = nums.length;
        for (int i = 1; i < nums.length; i++) {
            gcdAll = gcd(gcdAll, nums[i]);
            if (nums[i] == 1) {
                cnt++;
            }
        }
        // 所有数的共同gcd都没有1，那就不可能得到全是1
        if (gcdAll != 1) {
            return -1;
        }
        // 如果nums中存在1，那就直接由1向非1的地方扩充就好了
        if (cnt > 0) {
            return n - cnt;
        }
        // 可以全部变成1，但是不存在1，就需要找到能变成1的最短子数组，长度只有50，直接使用暴力遍历就可以了
        int miniSize = n;
        for (int i = 0; i < n - 1; i++) {
            int len = 1;
            int tmp = nums[i];
            for (int j = i + 1; j < n; j++) {
                tmp = gcd(tmp, nums[j]);
                len++;
                if (tmp == 1) {
                    miniSize = Math.min(miniSize, len);
                    break;
                }
            }
        }
        return (miniSize - 1) + n - 1;
    }

    int gcd(int x, int y) {
        while (x % y != 0) {
            int tmp = y;
            y = x % y;
            x = tmp;
        }
        return y;
    }
}
