package heat100.code_128_最长连续序列;

import java.util.HashMap;
import java.util.Map;

class Solution {

    // key - 连续序列的最大值，value - 以 key 为最大值时候，连续序列的长度
    private Map<Integer, Integer> map;

    public int longestConsecutive(int[] nums) {
        map = new HashMap<>();
        for (int num : nums) {
            map.put(num, 1);
        }
        int ans = 1;
        for (int num : nums) {
            int now = dfs(num);
            ans = Math.max(now, ans);
        }
        return ans;
    }

    int dfs(int num) {
        if (!map.containsKey(num)) {
            return 0;
        }
        if (map.get(num) != 1) {
            return map.get(num);
        }
        int prev = dfs(num - 1);
        int now = prev + 1;
        map.put(num, now);
        return now;
    }
}