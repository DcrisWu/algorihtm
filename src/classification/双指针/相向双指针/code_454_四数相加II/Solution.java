package classification.双指针.相向双指针.code_454_四数相加II;

import java.util.HashMap;
import java.util.Map;

class Solution {
    /**
     * 本道题的返回值是，四元组 == 0的组合数
     * 不要求去重，不要求返回具体的下标，所以只需要找到存在的组合，就可以 ans + 1
     * 为了降低时间复杂度，将四个数组分为两组，用 Map 存储每组的两数之和有多少个，再遍历另一组找它的相反数，添加到ans中
     */
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> countAB = new HashMap<>();
        for (int i : nums1) {
            for (int j : nums2) {
                countAB.put(i + j, countAB.getOrDefault(i + j, 0) + 1);
            }
        }
        int ans = 0;
        for (int i : nums3) {
            for (int j : nums4) {
                ans += countAB.getOrDefault(-i - j, 0);
            }
        }
        return ans;
    }
}