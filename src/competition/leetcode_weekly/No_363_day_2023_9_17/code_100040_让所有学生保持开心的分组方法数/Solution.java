package competition.leetcode_weekly.No_363_day_2023_9_17.code_100040_让所有学生保持开心的分组方法数;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution {
    // 第2题
    public int countWays(List<Integer> nums) {
        nums.sort(Comparator.comparingInt(a -> a));
        // 都没有选
        int ans = nums.get(0) > 0 ? 1 : 0;
        int n = nums.size();
        for (int i = 0; i < n; i++) {
            boolean c1 = false;
            boolean c2 = false;
            // i是最后一个被选中
            // 被选中的学生人数 严格大于 nums[i]
            if (i + 1 > nums.get(i)) {
                c1 = true;
            }
            // 不是最后一个
            if (i < n - 1) {
                if (i + 1 < nums.get(i + 1)) {
                    c2 = true;
                }
            } else {
                c2 = true;
            }
            if (c1 && c2) {
                ans++;
            }
        }
        return ans;
    }
}