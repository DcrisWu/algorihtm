package competition.day_2023_3_12.code_6317_统计美丽子数组数目;

import java.util.HashMap;
import java.util.Map;

/**
 * completion time = 2023.3.12
 */
class Solution {
    public long beautifulSubarrays(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int pre = 0;
        long ans = 0L;
        for (int num : nums) {
            pre = pre ^ num;
            ans += map.getOrDefault(pre, 0);
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return ans;
    }
}
