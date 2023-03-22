package classification.双指针.同向双指针.code_1004_最大连续1的个数III;

/**
 * completion time = 2023.3.22
 */
class Solution {
    /**
     * 本题思路跟code。424的思路相似
     * 因为只需要返回符合条件的子数组的长度，所以不需要保证滑动窗口中的数据一定符合要求，只需要维持出现过的符合要求的子数组的最大长度即可
     * 如果右指针移动之后发现不符合要求，就左指针移动一位，在遇到符合要求的更长的子数组前，这个滑动窗口的长度都不会改变
     */
    public int longestOnes(int[] nums, int k) {
        int historicalMax = 0;
        int one = 0;
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == 1) {
                one++;
                historicalMax = Math.max(historicalMax, one);
            }
            if (j - i + 1 - historicalMax > k) {
                if (nums[i] == 1) {
                    one--;
                }
                i++;
            }
        }
        return nums.length - i;
    }
}