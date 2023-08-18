package ByteDance.code_41_缺失的第一个正数;

class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            // <= 0的数不影响结果
            if (nums[i] <= 0) {
                nums[i] = n + 1;
            }
        }
        // 遍历后的数都 > 0
        for (int i = 0; i < n; i++) {
            // 获取索引下标
            int k = Math.abs(nums[i]);
            if (k <= n) {
                nums[k - 1] = -Math.abs(nums[k - 1]);
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
        int[] arr = {1,2,3};
        System.out.println(solution.firstMissingPositive(arr));

    }
}