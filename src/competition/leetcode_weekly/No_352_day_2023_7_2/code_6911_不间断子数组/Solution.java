package competition.leetcode_weekly.No_352_day_2023_7_2.code_6911_不间断子数组;

import java.util.ArrayList;
import java.util.List;

/**
 * completion time = 2023.7.2
 *
 * 使用单调栈
 * ans = ans + (r-l+1)
 * 加入之前的子数组已经符合条件，新加的元素也符合条件，那么 ans = 之前的 子数组长度 + 1
 */
class Solution {
    public long continuousSubarrays(int[] nums) {
        List<Integer> max = new ArrayList<>();
        List<Integer> min = new ArrayList<>();
        int l = 0;
        max.add(nums[0]);
        min.add(nums[0]);
        long ans = 1;
        for (int r = 1; r < nums.length; r++) {
            while (!max.isEmpty() && max.get(max.size() - 1) < nums[r]) {
                max.remove(max.size() - 1);
            }
            max.add(nums[r]);
            while (!min.isEmpty() && min.get(min.size() - 1) > nums[r]) {
                min.remove(min.size() - 1);
            }
            min.add(nums[r]);
            while (max.get(0) - min.get(0) > 2) {
                if (max.get(0) == nums[l]) {
                    max.remove(0);
                }
                if (min.get(0) == nums[l]) {
                    min.remove(0);
                }
                l++;
            }
            ans += r - l + 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {5, 4, 2, 4};
        Solution solution = new Solution();
        System.out.println(solution.continuousSubarrays(arr));
    }
}
