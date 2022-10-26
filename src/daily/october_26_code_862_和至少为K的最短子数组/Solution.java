package daily.october_26_code_862_和至少为K的最短子数组;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * completion time = 2022.10.26
 */
class Solution {
    public int shortestSubarray(int[] nums, int k) {
        long[] preSum = new long[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
        Deque<Integer> queue = new LinkedList<>();
        queue.addLast(0);
        int ans = -1;
        for (int i = 1; i < preSum.length; i++) {
            long curSum = preSum[i];
            while (!queue.isEmpty() && curSum - preSum[queue.peekFirst()] >= k) {
                if (ans == -1) {
                    ans = i - queue.pollFirst();
                } else {
                    ans = Math.min(ans, i - queue.pollFirst());
                }
            }
            while (!queue.isEmpty() && preSum[queue.peekLast()] >= curSum) {
                queue.pollLast();
            }
            queue.addLast(i);
        }
        return ans;
    }
}
