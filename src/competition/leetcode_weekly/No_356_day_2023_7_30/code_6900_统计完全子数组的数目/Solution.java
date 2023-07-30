package competition.leetcode_weekly.No_356_day_2023_7_30.code_6900_统计完全子数组的数目;

import java.util.HashSet;
import java.util.Set;

/**
 * completion time = 2023.7.30
 */
class Solution {
    public int countCompleteSubarrays(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int res = 0;
        int size = set.size();
        for (int i = 0; i < nums.length; i++) {
            set.clear();
            for (int j = i; j < nums.length; j++) {
                set.add(nums[j]);
                if (set.size() == size){
                    res++;
                }
            }
        }
        return res;
    }
}