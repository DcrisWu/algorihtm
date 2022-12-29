package TowardsOffers2.code_39_数组中出现次数超过一半的数字;

import java.lang.reflect.Array;
import java.util.Arrays;

class Solution {
    public int majorityElement(int[] nums) {
        int half = nums.length / 2;
        Arrays.sort(nums);
        int i = 0;
        int ans = 0;
        while (i + half < nums.length) {
            if (nums[i] == nums[i + half]) {
                ans = nums[i];
            }
            while (i + 1 < nums.length && nums[i + 1] == nums[i]) {
                i++;
            }
            i++;
        }
        return ans;
    }
}
