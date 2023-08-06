package competition.leetcode_weekly.No_357_day_2023_8_6.code_6953_判断是否能拆分数组;

import java.util.ArrayList;
import java.util.List;

/**
 * completion time = 2023.8.6
 */
class Solution {

    public boolean canSplitArray(List<Integer> nums, int m) {
        int n = nums.size();
        if (n <= 2) {
            return true;
        }
        for (int i = 0; i < n - 1; i++) {
            if (nums.get(i) + nums.get(i + 1) >= m) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(1);
        System.out.println(new Solution().canSplitArray(nums, 5));
    }
}
