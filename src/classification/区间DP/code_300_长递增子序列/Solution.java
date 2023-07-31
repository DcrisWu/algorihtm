package classification.区间DP.code_300_长递增子序列;

import java.util.ArrayList;
import java.util.List;

/**
 * completion time = 2023.7.21
 * <p>
 * 最长子序列不可以用单调栈，例：0 1 0 3 2 3，用单调栈，遇到第二个0，就会算成 0 2 3，但最长子序列为 0 1 2 3
 * 只能用回溯 / 二分+贪心
 */
public class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            int l = 0, r = list.size() - 1;
            int ans = list.size();
            while (l <= r) {
                int mid = (l + r) >> 1;
                // 如果不需要严格递增，就需要找到第一个 > nums[i] 的下标
                // 这里要求严格递增，所以要找到第一个 >= nums[i]的下标即可
                if (nums[i] <= list.get(mid)) {
                    ans = mid;
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            if (ans == list.size()) {
                list.add(nums[i]);
            } else {
                list.set(ans, nums[i]);
            }
        }

        return list.size();
    }
}
