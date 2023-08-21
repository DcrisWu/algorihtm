package competition.leetcode_weekly.No_359_day_2023_8_20.code_6467_找出最长等值子数组;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * completion time = 2023.8.20
 */
class Solution {
    public int longestEqualSubarray(List<Integer> nums, int k) {
        Map<Integer, ArrayDeque<Integer>> map = new HashMap<>();
        Map<Integer, Integer> count = new HashMap<>();
        int ans = 0;
        for (int i = 0; i < nums.size(); i++) {
            map.putIfAbsent(nums.get(i), new ArrayDeque<>());
            ArrayDeque<Integer> q = map.get(nums.get(i));
            q.addLast(i);
            count.put(nums.get(i), count.getOrDefault(nums.get(i), 0) + 1);
            while (!q.isEmpty() && (i - q.peekFirst() + 1) - count.get(nums.get(i)) > k) {
                q.pollFirst();
                count.put(nums.get(i), count.get(nums.get(i)) - 1);
            }
            ans = Math.max(count.get(nums.get(i)), ans);
        }
        return ans;
    }
}