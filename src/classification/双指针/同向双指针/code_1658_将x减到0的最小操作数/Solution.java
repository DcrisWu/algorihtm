package classification.双指针.同向双指针.code_1658_将x减到0的最小操作数;

import java.util.Arrays;

/**
 * completion time = 2023.3.22
 */
class Solution {
    /**
     * 由于数据的设置，及时将数组加起来，也不会超过int的上限，所以首先将数据全部相加，再减去x就是我们需要的滑动窗口的和 target
     * 如果 滑动窗口 < target，右指针移动
     * 如果 滑动窗口 == target，就记录最长的滑动窗口
     * 如果 滑动窗口 > target，就不断移动左指针，直到 滑动窗口 <= target，如果如果 滑动窗口 == target，就记录最长的滑动窗口，注意保证i <= j
     * 循环完之后，数组长度 - 窗口大小 就是答案，如果窗口大小为0，就返回 -1
     */
    public int minOperations(int[] nums, int x) {
        int target = Arrays.stream(nums).sum() - x;
        int ans = nums.length + 1;
        int sum = 0;
        for (int i = 0, j = 0; j < nums.length; j++) {
            sum += nums[j];
            if (sum == target) {
                ans = Math.min(ans, nums.length - (j - i + 1));
            }
            while (i <= j && sum > target) {
                sum -= nums[i++];
                if (sum == target) {
                    ans = Math.min(ans, nums.length - (j - i + 1));
                }
            }
        }
        return ans == nums.length + 1 ? -1 : ans;
    }
}