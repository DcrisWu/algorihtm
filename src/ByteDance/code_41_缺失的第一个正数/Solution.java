package ByteDance.code_41_缺失的第一个正数;

class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        // 如果nums为 1 ~ n，那么答案就是 n + 1
        int ans = n + 1;
        // 全是正数了
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0) {
                nums[i] = n + 1;
            }
        }
        // idx = nums[i]，将nums[idx] 变成负数，那么第一个不是负数的下标 + 1就是答案
        for (int i = 0; i < n; i++) {
            int idx = Math.abs(nums[i]) - 1;
            if (idx < n) {
                nums[idx] = -Math.abs(nums[idx]);
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                ans = i + 1;
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1, 2, 3};
        System.out.println(solution.firstMissingPositive(arr));

    }
}