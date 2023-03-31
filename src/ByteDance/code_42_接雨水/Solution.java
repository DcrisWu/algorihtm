package ByteDance.code_42_接雨水;

class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int leftHeight = 0, rightHeight = n - 1;
        for (int i = 0; i < n; i++) {
            if (height[i] > height[leftHeight]) {
                leftHeight = i;
            }
            left[i] = height[leftHeight];
            if (height[n - i - 1] > height[rightHeight]) {
                rightHeight = n - i - 1;
            }
            right[n - i - 1] = height[rightHeight];
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int tall = Math.min(left[i], right[i]) - height[i];
            if (tall > 0) {
                ans += tall;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        Solution solution = new Solution();
        System.out.println(solution.trap(height));
    }
}