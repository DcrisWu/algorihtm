package ByteDance.code_560_和为K的子数组;

import java.util.HashMap;
import java.util.Map;

/**
 * coampletion time = 2023.10.29
 */
class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        int cnt = 0;
        for (int num : nums) {
            sum += num;
            cnt += map.getOrDefault(sum - k, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return cnt;
    }
}