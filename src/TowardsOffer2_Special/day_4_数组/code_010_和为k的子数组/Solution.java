package TowardsOffer2_Special.day_4_数组.code_010_和为k的子数组;

import java.util.HashMap;
import java.util.Map;

/**
 * completion time = 2022.10.17
 */
class Solution {
    public int subarraySum(int[] nums, int k) {
        /*int[] preSum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
        int count = 0;
        for (int i = 1; i < preSum.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if(preSum[i]-preSum[j] == k){
                    count++;
                }
            }
        }
        return count;*/

        int pre = 0;
        int count = 0;
        // 键存储的是前缀和，值存储的是前缀和出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        // 前缀和0一定存在
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (map.containsKey(pre - k)) {
                count += map.get(map.get(pre - k));
            }
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {-1, -1, 1};
        System.out.println(solution.subarraySum(arr, 0));
    }
}