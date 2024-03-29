package ByteDance.code_215_数组中的第K个最大元素;

import java.util.PriorityQueue;

/**
 * completion time = 2023.8.18
 */
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int num : nums) {
            q.add(num);
            while (q.size() > k) {
                q.poll();
            }
        }
        return q.peek();
    }
}
