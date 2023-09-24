package competition.leetcode_weekly.No_363_day_2023_9_17.code_100031_计算K置位下标对应元素的和;

import java.util.List;

class Solution {
    // 第1题
    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int sum = 0;
        for (int i = 0; i < nums.size(); i++) {
            int count = 0;
            for (int j = 0; j < 32; j++) {
                if ((i >> j & 1) == 1) {
                    count++;
                }
            }
            if (count == k) {
                sum += nums.get(i);
            }
        }
        return sum;
    }
}
