package classification.双指针.同向双指针.code_283_移动零;

class Solution {
    /**
     * 首先通过遍历，找到当前情况下，第一个0的下标 i
     * 从 i+1 开始往后遍历，找到第一个非0的下标j，然后swap两个数
     * 然后寻找下一个 nums[i] == 0的 i，重复上述步骤，直到 i >= nums.length 或者 j >= nums.length
     */
    public void moveZeroes(int[] nums) {
        // i 指向第一个 0 元素，j 指向 i之后第一个非 0 元素
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == 0) {
                int j = i + 1;
                while (j < nums.length && nums[j] == 0) {
                    j++;
                }
                if (j < nums.length) {
                    nums[i] = nums[j];
                    nums[j] = 0;
                } else {
                    break;
                }
            }
            i++;
        }
    }
}
