package TowardsOffer2_Special.day_24_二分查找.code_狒狒吃香蕉;

/**
 * completion time = 2022.11.4
 */
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1, r = (int) 1e9;
        int ans = r;
        while (l <= r) {
            int mid = (l + r) >> 1;
            int cost = 0;
            for (int pile : piles) {
                cost += (pile - 1) / mid + 1;
            }
            // 速度够快了，尝试速度更慢
            if (cost <= h) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }
}
