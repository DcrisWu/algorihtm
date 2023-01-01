package TowardsOffers2.code_56_II_数组中数字出现的次数II;

class Solution {
    public int singleNumber(int[] nums) {
        int x = 0;
        for (int i = 0; i < 32; i++) {
            int bit = 0;
            for (int num : nums) {
                bit += (num >> i) & 1;
            }
            bit %= 3;
            x += bit << i;
        }
        return x;
    }
}
