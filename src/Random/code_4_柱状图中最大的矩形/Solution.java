package Random.code_4_柱状图中最大的矩形;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Deque<Integer> st = new ArrayDeque<>();
        st.addLast(-1);
        for (int i = 0; i < n; i++) {
            while (st.size() > 1 && heights[st.peekLast()] >= heights[i]) {
                right[st.pollLast()] = i;
            }
            left[i] = st.peekLast();
            st.addLast(i);
        }
        while (st.size() > 1) {
            right[st.pollLast()] = n;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, heights[i] * (right[i] - left[i] - 1));
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
    }
}