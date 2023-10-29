package ByteDance.code_239_滑动窗口最大值;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;

/**
 * completion time = 2023.10.29
 */
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

        int n = nums.length;
        int[] ans = new int[n - k + 1];
        // 单调递减栈
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[stack.peekLast()] <= nums[i]) {
                stack.pollLast();
            }
            stack.addLast(i);
            while (!stack.isEmpty() && stack.peekFirst() + k <= i) {
                stack.pollFirst();
            }
            if (i - k + 1 >= 0) {
                ans[i - k + 1] = nums[stack.peekFirst()];
            }
        }
        return ans;
    }
}
