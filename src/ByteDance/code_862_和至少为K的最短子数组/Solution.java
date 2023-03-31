package ByteDance.code_862_和至少为K的最短子数组;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int shortestSubarray(int[] nums, int k) {
        // 前缀和可能越界，所以要用long
        long[] preSum = new long[nums.length];
        preSum[0] = nums[0];
        // 前缀和
        for (int i = 1; i < nums.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i];
        }
        // 单调递增栈，栈存的元素是下标i
        Deque<Integer> stack = new LinkedList<>();
        int min = nums.length + 1;
        for (int i = 0; i < nums.length; i++) {
            // 假设子数组长度是 0 - i
            if (preSum[i] >= k) {
                min = Math.min(min, i + 1);
            }
            // 找到满足条件的最短长度
            while (!stack.isEmpty() && preSum[i] - preSum[stack.peekFirst()] >= k) {
                Integer first = stack.pollFirst();
                min = Math.min(i - first + 1, min);
            }
            // 将下标i入栈
            while (!stack.isEmpty() && preSum[stack.peekLast()] > preSum[i]) {
                stack.pollLast();
            }
            stack.addLast(i);
        }
        return min == nums.length+1 ? -1 : min;
    }
}
