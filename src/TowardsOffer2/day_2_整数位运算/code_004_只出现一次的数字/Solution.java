package TowardsOffer2.day_2_整数位运算.code_004_只出现一次的数字;

/**
 * completion time = 2022.10.15
 */
class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        // 出现了三次的数字的每一位出现了3次，所以，每一位的和要么是0，要么是3
        for (int i = 0; i < 32; i++) {
            int total = 0;
            for (int num : nums) {
                total += ((num >> i) & 1);
            }
            if (total % 3 != 0) {
                ans = ans | (1 << i);
            }
        }
        return ans;
    }
}
