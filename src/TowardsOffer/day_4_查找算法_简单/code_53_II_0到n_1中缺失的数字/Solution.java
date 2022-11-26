package TowardsOffer.day_4_查找算法_简单.code_53_II_0到n_1中缺失的数字;

class Solution {
    public int missingNumber(int[] nums) {
        if (nums[0] != 0) {
            return 0;
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - 1 != nums[i - 1]) {
                return nums[i] - 1;
            }
        }
        return nums[nums.length - 1] + 1;
    }
}