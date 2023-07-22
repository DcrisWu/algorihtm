package classification.最长递增子序列.code_1671_得到山形数组的最少删除次数;

/**
 * completion time = 2023.7.22
 */
class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        int[] up = new int[n];
        int[] down = new int[n];
        for (int i = 0; i < n; i++) {
            up[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && up[j] + 1 > up[i]) {
                    up[i] = up[j] + 1;
                }
            }
        }
        int ans = n;
        for (int i = n - 1; i >= 0; i--) {
            down[i] = 1;
            for (int j = n - 1; j > i; j--) {
                if (nums[i] > nums[j] && down[j] + 1 > down[i]) {
                    down[i] = down[j] + 1;
                }
            }
            if (up[i] > 1 && down[i] > 1) {
                ans = Math.min(ans, n - (up[i] + down[i]) + 1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {100, 92, 89, 77, 74, 66, 64, 66, 64};
        System.out.println(new Solution().minimumMountainRemovals(arr));
    }
}