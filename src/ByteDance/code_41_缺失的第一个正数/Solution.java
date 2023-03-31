package ByteDance.code_41_缺失的第一个正数;

class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        // 先把 <= 0的数全部编程n+1，不可以一边更新一边遍历，因为这样可能出现之前已经对下标i的数变为负数，后面又更新，变成了正数
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0) {
                nums[i] = n + 1;
            }
        }
        for (int i = 0; i < n; i++) {
            // 先获取绝对值，因为nums[i]可能存在负值
            int index = Math.abs(nums[i]) - 1;
            if (index < n) {
                nums[index] = -Math.abs(nums[index]);
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
        int[] arr = {7, 8, 9, 11, 12};
        System.out.println(solution.firstMissingPositive(arr));

    }
}