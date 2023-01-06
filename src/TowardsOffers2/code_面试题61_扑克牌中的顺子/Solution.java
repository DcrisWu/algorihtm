package TowardsOffers2.code_面试题61_扑克牌中的顺子;

import java.util.Arrays;

class Solution {
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int zeros = 0;
        for (int i = 0; i < nums.length && nums[i] == 0; i++) {
            zeros++;
        }
        int expect = nums[zeros];
        int i = zeros;
        while (i < nums.length) {
            if (nums[i] == expect) {
                expect++;
                i++;
            } else {
                if (zeros > 0) {
                    zeros--;
                    expect++;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
