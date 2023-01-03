package TowardsOffers2.code_59_I_滑动窗口的最大值;

import java.util.*;

class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        int[] ans = new int[nums.length - k + 1];
        ans[0] = nums[deque.peekFirst()];
        for (int i = k; i < nums.length; i++) {
            int left = i - k + 1;
            while (!deque.isEmpty() && deque.peekFirst() < left) {
                deque.pollFirst();
            }
            while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            ans[i - k + 1] = nums[deque.peekFirst()];
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        for (int i : solution.maxSlidingWindow(arr, 3)) {
            System.out.println(arr[i]);
        }
    }
}
