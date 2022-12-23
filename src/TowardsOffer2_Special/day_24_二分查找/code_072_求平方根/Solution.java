package TowardsOffer2_Special.day_24_二分查找.code_072_求平方根;

/**
 * completion time = 2022.11.4
 */
class Solution {
    public int mySqrt(int x) {
        long l = 0L;
        long r = (long) Math.pow(2, 16);
        int ans = 0;
        while (l <= r) {
            long mid = (l + r) >> 1;
            if (x >= Math.pow(mid, 2)) {
                ans = (int) mid;
                l = mid + 1L;
            } else {
                r = mid - 1L;
            }
        }
        return ans;
    }
}
