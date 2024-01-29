package ByteDance.code_41_缺失的第一个正数;

class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        // 将非正数全部变成正数
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0) {
                nums[i] = n + 1;
            }
        }
        // 遇到一个绝对值 <= n 的正数，就把对应 idx = num - 1 处的数变为负数
        for (int num : nums) {
            int idx = Math.abs(num) - 1;
            if (idx < n) {
                nums[idx] = -Math.abs(nums[idx]);
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return n + 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1, 2, 3};
        System.out.println(solution.firstMissingPositive(arr));

    }
}