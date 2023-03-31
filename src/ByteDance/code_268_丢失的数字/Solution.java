package ByteDance.code_268_丢失的数字;

class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                nums[i] = n + 1;
            }
        }
        for (int i = 0; i < n; i++) {
            int index = Math.abs(nums[i]);
            if (index <= n) {
                nums[index - 1] = -Math.abs(nums[index - 1]);
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return 0;
    }
}
