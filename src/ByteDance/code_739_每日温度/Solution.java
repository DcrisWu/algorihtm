package ByteDance.code_739_每日温度;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * completion time = 2023.10.22
 */
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        // 单调递减栈
        Deque<Integer> st = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && temperatures[st.peekLast()] < temperatures[i]) {
                Integer pre = st.pollLast();
                ans[pre] = i - pre;
            }
            st.addLast(i);
        }
        return ans;
    }
}
