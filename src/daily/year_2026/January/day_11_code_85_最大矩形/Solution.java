package daily.year_2026.January.day_11_code_85_最大矩形;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix[0].length;
        int[] height = new int[n];
        int res = 0;
        for (char[] chars : matrix) {
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == '1') {
                    height[i] += 1;
                } else {
                    height[i] = 0;
                }
            }
            res = Math.max(res, func(height));
        }
        return res;
    }

    int func(int[] height) {
        // 单调递增栈
        int n = height.length;
        Deque<Integer> st = new ArrayDeque<>();
        st.add(-1);
        int[] left = new int[n];
        int[] right = new int[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int h = height[i];
            while (st.size() > 1 && height[st.peekLast()] >= h) {
                Integer idx = st.pollLast();
                right[idx] = i;
            }
            left[i] = st.peekLast();
            st.add(i);
        }
        while (st.size() > 1){
            right[st.pollLast()] = n;
        }
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, height[i] * (right[i] - left[i] - 1));
        }
        return ans;
    }

    public static void main(String[] args) {
        char[][] matrix = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        System.out.println(new Solution().maximalRectangle(matrix));
    }
}