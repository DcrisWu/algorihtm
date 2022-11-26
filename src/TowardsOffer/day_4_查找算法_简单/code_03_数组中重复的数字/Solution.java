package TowardsOffer.day_4_查找算法_简单.code_03_数组中重复的数字;

import java.util.Arrays;

/**
 * completion time = 2022.11.23
 */
class Solution {
    public int findRepeatNumber(int[] nums) {
        /*Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)){
                return num;
            }
            set.add(num);
        }
        return 0;*/
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1]){
                return nums[i];
            }
        }
        return 0;
    }
}