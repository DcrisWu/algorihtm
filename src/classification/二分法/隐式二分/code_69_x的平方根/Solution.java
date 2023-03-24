package classification.二分法.隐式二分.code_69_x的平方根;

/**
 * completion time = 2023.3.24
 */
class Solution {
    /**
     * 因为不能直接使用内置函数求根，所以就考虑用平方
     * 题目就变成了，求满足 ans * ans <= x 的最大ans
     */
    public int mySqrt(int x) {
        long l = 0, r = Integer.MAX_VALUE;
        long ans = 0;
        while (l <= r) {
            long mid = (l + r) >> 1;
            if (mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return (int) ans;
    }
}