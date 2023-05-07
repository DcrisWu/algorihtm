package competition.leetcode_weekly.No_344_day_2023_5_7.code_6416_找出不同元素数目差数组;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * completion time = 2023.5.7
 */
class Solution {
    public int[] distinctDifferenceArray(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Map<Integer, Integer> pre = new HashMap<>();
        Set<Integer> suf = new HashSet<>();
        for (int i = 0; i < n; i++) {
            pre.put(nums[i], pre.getOrDefault(nums[i], 0) + 1);
            res[i] = pre.size();
        }
        for (int i = n - 1; i >= 0; i--) {
            res[i] = pre.size() - suf.size();
            suf.add(nums[i]);
            pre.put(nums[i], pre.get(nums[i]) - 1);
            if (pre.get(nums[i]) == 0) {
                pre.remove(nums[i]);
            }
        }
        return res;
    }
}