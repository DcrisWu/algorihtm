package Random.code_42_接雨水;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] left = new int[n];
        int[] right = new int[n];
//        Deque<Integer> stack = new ArrayDeque<>();
        int leftHeight = 0;
        int rightHeight = n - 1;
        for (int i = 0; i < n; i++) {
            if (height[i] >= height[leftHeight]) {
                left[i] = -1;
                leftHeight = i;
            } else {
                left[i] = height[leftHeight];
            }
            if (height[n - i - 1] >= height[rightHeight]) {
                right[n - i - 1] = -1;
                rightHeight = n - i - 1;
            } else {
                right[n - i - 1] = height[rightHeight];
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (left[i] == -1 || right[i] == -1) {
                continue;
            }
            ans += Math.min(left[i], right[i]) - height[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        Solution solution = new Solution();
        System.out.println(solution.trap(arr));
    }
}
