package ByteDance.code_128_最长连续序列;

import java.util.HashMap;
import java.util.Map;

/**
 * completion time = 2023.10.22
 */
class Solution {
    private Map<Integer, Integer> map;

    public int longestConsecutive(int[] nums) {
        map = new HashMap<>();
        for (int num : nums) {
            map.put(num, 0);
        }
        int ans = 0;
        for (int num : nums) {
            ans = Math.max(ans, dfs(num));
        }
        return ans;
    }

    int dfs(int num) {
        if (map.get(num) != 0) {
            return map.get(num);
        }
        int dept = 1;
        if (map.containsKey(num - 1)) {
            dept += dfs(num - 1);
        }
        map.put(num, dept);
        return dept;
    }
}
