package ByteDance.code_239_滑动窗口最大值;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        /*// 优先队列，存的是下标
        PriorityQueue<Integer> q = new PriorityQueue<>((o1, o2) -> nums[o2] - nums[o1]);
        int len = nums.length;
        int n = len - k + 1;
        for (int i = 0; i < k - 1; i++) {
            q.add(i);
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            q.add(i + k - 1);
            while (!q.isEmpty() && q.peek() < i) {
                q.poll();
            }
            ans[i] = nums[q.peek()];
        }
        return ans;*/

        // 单调递减栈
        Deque<Integer> stack = new ArrayDeque<>();
        int n = nums.length - k + 1;
        for (int i = 0; i < k - 1; i++) {
            while (!stack.isEmpty() && nums[i] >= nums[stack.peekLast()]) {
                stack.pollLast();
            }
            stack.add(i);
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[i + k - 1] >= nums[stack.peekLast()]) {
                stack.pollLast();
            }
            stack.add(i + k - 1);
            while (!stack.isEmpty() && stack.peekFirst() < i) {
                stack.pollFirst();
            }
            ans[i] = nums[stack.peekFirst()];
        }
        return ans;
    }
}
