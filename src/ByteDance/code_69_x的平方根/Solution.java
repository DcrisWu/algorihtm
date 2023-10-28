package ByteDance.code_69_x的平方根;

/**
 * completion time = 2023.10.28
 */
class Solution {
    public int mySqrt(int x) {
        long l = 0, r = Integer.MAX_VALUE;
        long ans = l;
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