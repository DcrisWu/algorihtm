package TowardsOffers2.code_56_I_数组中数字出现的次数;

class Solution {
    public int[] singleNumbers(int[] nums) {
        int x = nums[0];
        for (int i = 1; i < nums.length; i++) {
            x ^= nums[i];
        }
        int m = 1;
        while ((m & x) == 0) {
            m <<= 1;
        }
        int a = 0, b = 0;
        for (int num : nums) {
            // 如果第 i 位是 0
            if ((num & m) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }
        return new int[]{a, b};
    }
}
