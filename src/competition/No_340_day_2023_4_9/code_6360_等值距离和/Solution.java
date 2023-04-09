package competition.No_340_day_2023_4_9.code_6360_等值距离和;

import java.util.*;

/**
 * completion time = 2023.4.9
 */
class Solution {
    public long[] distance(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.putIfAbsent(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }
        long[] ans = new long[nums.length];
        for (Integer key : map.keySet()) {
            List<Integer> list = map.get(key);
            // preSum[i] 表示不包含下标nums[i]的下标前缀和
            int n = list.size();
            long[] preSum = new long[n + 1];
            for (int i = 0; i < n; i++) {
                preSum[i + 1] = list.get(i) + preSum[i];
            }
            for (int i = 0; i < n; i++) {
                int target = list.get(i);
                // 下标i表示list.get(i)前面有多少个数
                long left = (long) target * i - preSum[i];
                long right = preSum[n] - preSum[i] - (long) target * (n - i);
                ans[target] = left + right;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {3,1, 3, 1, 1, 2};
        long[] distance = solution.distance(arr);
        System.out.println(distance);
    }
}