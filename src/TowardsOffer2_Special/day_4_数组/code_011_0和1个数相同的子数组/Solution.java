package TowardsOffer2_Special.day_4_数组.code_011_0和1个数相同的子数组;

import java.util.HashMap;
import java.util.Map;

/**
 * completion time = 2022.10.17
 */
class Solution {
    public int findMaxLength(int[] nums) {
        int[] preSum = new int[nums.length + 1];
        Map<Integer, Integer> map = new HashMap<>();
        map.putIfAbsent(0, 0);
        int len = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                preSum[i + 1] = preSum[i] - 1;
            } else {
                preSum[i + 1] = preSum[i] + 1;
            }
            map.putIfAbsent(preSum[i + 1], i + 1);
            len = Math.max(len, i + 1 - map.get(preSum[i + 1]));
        }
        return len;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {0, 1, 0, 1};
        System.out.println(solution.findMaxLength(arr));
    }
}
