package ByteDance.code_862_和至少为K的最短子数组;


import java.util.ArrayDeque;
import java.util.Deque;

/**
 * completion time = 2023.10.24
 */
class Solution {
    public int shortestSubarray(int[] nums, int k) {
        // 单调递增栈
        long preSum = 0;
        int ans = Integer.MAX_VALUE;
        // int[0]表示前缀和，int[1]表示前缀和的下标 i
        Deque<long[]> st = new ArrayDeque<>();
        st.addLast(new long[]{0, -1});
        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i];
            // 先寻找是否有满足条件的子数组
            // 遍历开始的时候，肯定不为空
            while (!st.isEmpty()) {
                long[] first = st.peekFirst();
                if (preSum - first[0] >= k) {
                    ans = Math.min(ans, i - (int) first[1]);
                    st.pollFirst();
                } else {
                    break;
                }
            }
            // 再维持单调栈
            while (!st.isEmpty() && st.peekLast()[0] >= preSum) {
                st.pollLast();
            }
            st.addLast(new long[]{preSum, i});
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
